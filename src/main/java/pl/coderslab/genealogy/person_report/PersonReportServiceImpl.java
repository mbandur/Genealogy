package pl.coderslab.genealogy.person_report;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.genealogy.document.Document;
import pl.coderslab.genealogy.document.DocumentRepository;
import pl.coderslab.genealogy.event.Event;
import pl.coderslab.genealogy.event.EventRepository;
import pl.coderslab.genealogy.exception.ResourceNotFoundException;
import pl.coderslab.genealogy.divide_relations.DivideRelationsDTO;
import pl.coderslab.genealogy.divide_relations.DivideRelationsService;
import pl.coderslab.genealogy.name_nationality.CountriesDTO;
import pl.coderslab.genealogy.name_nationality.NameNationalityService;
import pl.coderslab.genealogy.person.PersonDTO;
import pl.coderslab.genealogy.person.Person;
import pl.coderslab.genealogy.person.PersonMapper;
import pl.coderslab.genealogy.person.PersonRepository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonReportServiceImpl implements PersonReportService {

    private final DocumentRepository documentRepository;
    private final EventRepository eventRepository;
    private final PersonRepository personRepository;
    private final DivideRelationsService divideRelationsService;
    private final PersonReportMapper personReportMapper;
    private final PersonMapper personMapper;
    private final NameNationalityService nameNationalityService;

    public PersonReportDTO findAllDataByPersonId(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> ResourceNotFoundException.forId(id.toString()));
        List<Document> documents = documentRepository.findDocumentByPerson1(person);
        List<Event> events = eventRepository.findEventByPerson1(person);
        List<DivideRelationsDTO> listMergedRelationsDTO = divideRelationsService.findAllRelationsByPerson(person);
        Map<String, Set<Person>> relationsMap = listMergedRelationsDTO.stream()
                .collect(Collectors.groupingBy(
                        DivideRelationsDTO::relationType1,
                        Collectors.mapping(DivideRelationsDTO::person2, Collectors.toSet())
                ));
        List<DocumentPersonReportDTO> documentsReportDTO = personReportMapper.mapToDocumentReportDTO(documents);
        List<EventPersonReportDTO> eventsReportDTO = personReportMapper.mapToEventReportDTO(events);
        Map<String, Set<PersonDTO>> relationsMapDTO = personReportMapper.mapToRelationsMapDTO(relationsMap);
        PersonDTO personDTO = personMapper.mapToPersonDTO(person);
        CountriesDTO countriesDTO = nameNationalityService.getNameNationality(person.getFirstName());
        return new PersonReportDTO(personDTO, documentsReportDTO, eventsReportDTO, relationsMapDTO, countriesDTO);
    }
}