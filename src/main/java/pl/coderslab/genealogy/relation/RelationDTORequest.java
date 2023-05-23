package pl.coderslab.genealogy.relation;

import pl.coderslab.genealogy.validation.ValueOfEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record RelationDTORequest(
        Long id,
        @NotNull Long person1,
        @NotNull Long person2,
        @NotNull @ValueOfEnum(enumClass = RelationType.class)
        String relationType1,
        @NotNull @ValueOfEnum(enumClass = RelationType.class)
        String relationType2,
        @Size(max = 255, message = "Max size = 255")
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