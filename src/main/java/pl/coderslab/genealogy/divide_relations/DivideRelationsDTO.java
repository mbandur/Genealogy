package pl.coderslab.genealogy.divide_relations;

import pl.coderslab.genealogy.person.Person;

import javax.validation.constraints.NotBlank;

public record DivideRelationsDTO(
        @NotBlank Person person1,
        @NotBlank Person person2,
        @NotBlank String relationType1
) {
}