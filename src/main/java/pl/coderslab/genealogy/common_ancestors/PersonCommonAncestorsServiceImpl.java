package pl.coderslab.genealogy.common_ancestors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.genealogy.exception.ResourceNotFoundException;
import pl.coderslab.genealogy.divide_relations.DivideRelationsDTO;
import pl.coderslab.genealogy.divide_relations.DivideRelationsService;
import pl.coderslab.genealogy.person.PersonDTO;
import pl.coderslab.genealogy.person.Person;
import pl.coderslab.genealogy.person.PersonMapper;
import pl.coderslab.genealogy.person.PersonRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PersonCommonAncestorsServiceImpl implements PersonCommonAncestorsService {
    private final PersonRepository personRepository;
    private final DivideRelationsService divideRelationsService;
    private final PersonMapper personMapper;

    @Override
    @Transactional
    public List<PersonDTO> find(Long id1, Long id2, Long range) {
        Person person1 = personRepository.findById(id1).orElseThrow(() -> ResourceNotFoundException.forId(id1.toString()));
        Person person2 = personRepository.findById(id2).orElseThrow(() -> ResourceNotFoundException.forId(id2.toString()));
        List<Person> person1AncestorsList = convertToFlatList(person1, range);
        List<Person> person2AncestorsList = convertToFlatList(person2, range);
                return person1AncestorsList.stream()
                .filter(person2AncestorsList::contains)
                .map(personMapper::mapToPersonDTO)
                .collect(Collectors.toList());
    }

    private List<Person> convertToFlatList(Person person, Long range) {
        List<Person> temporaryPersonList = new ArrayList<>(Arrays.asList(person));
        List<Person> endPersonList = temporaryPersonList;
        for (int actualLoopValue = 0; actualLoopValue < range; actualLoopValue++) {
            temporaryPersonList = findParents(temporaryPersonList);
            endPersonList.addAll(temporaryPersonList);
        }
        return endPersonList;
    }

    public List<Person> findParents(List<Person> persons) {
        return persons
                .stream()
                .map(divideRelationsService::findAllRelationsByPerson)
                .flatMap(Collection::stream)
                .filter(s -> s.relationType1().equals("mother") || s.relationType1().equals("father"))
                .map(DivideRelationsDTO::person2)
                .collect(Collectors.toList());
    }
}