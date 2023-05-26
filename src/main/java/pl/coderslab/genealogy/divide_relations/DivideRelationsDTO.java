package pl.coderslab.genealogy.divide_relations;

import pl.coderslab.genealogy.person.Person;

import javax.validation.constraints.NotBlank;

public record DivideRelationsDTO(
        Person person1,
        Person person2,
        String relationType1
) {
}