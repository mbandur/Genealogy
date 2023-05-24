package pl.coderslab.genealogy.person_report;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.coderslab.genealogy.document.Document;
import pl.coderslab.genealogy.event.Event;
import pl.coderslab.genealogy.person.PersonDTO;
import pl.coderslab.genealogy.person.Person;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface PersonReportMapper {
    PersonReportMapper INSTANCE = Mappers.getMapper(PersonReportMapper.class);

    List<DocumentPersonReportDTO> mapToDocumentReportDTO(List<Document> DocumentEntity);

    List<EventPersonReportDTO> mapToEventReportDTO(List<Event> eventEntity);

    Set<PersonDTO> map(Set<Person> personSet);

    Map<String, Set<PersonDTO>> mapToRelationsMapDTO(Map<String, Set<Person>> relationsMap);
}