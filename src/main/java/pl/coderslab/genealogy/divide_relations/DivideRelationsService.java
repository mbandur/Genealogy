package pl.coderslab.genealogy.divide_relations;

import pl.coderslab.genealogy.person.Person;

import java.util.List;

public interface DivideRelationsService {
    List<DivideRelationsDTO> findAllRelationsByPerson(Person person);
}