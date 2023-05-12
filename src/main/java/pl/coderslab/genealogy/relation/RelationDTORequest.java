package pl.coderslab.genealogy.relation;

import pl.coderslab.genealogy.validation.EnumPattern;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record RelationDTORequest(
        Long id,
        @NotNull Long person1,
        @NotNull Long person2,
        @NotNull @EnumPattern(regexp = "^M|F$", message = "Only M or F value")
        RelationType relationType1,
        @NotNull @EnumPattern(regexp = "^mother|father|wife|husband|children|siblings$"
                , message = "Only: mother, father, wife, husband, children, siblings value")
        RelationType relationType2,
        @Size(max = 255)
        String comments
) {
    public RelationDTORequest withId(Long id) {
        return new RelationDTORequest(
                id,
                person1(),
                person2(),
                relationType1(),
                relationType2(),
                comments());
    }
}