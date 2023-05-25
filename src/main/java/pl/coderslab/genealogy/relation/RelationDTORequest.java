package pl.coderslab.genealogy.relation;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.coderslab.genealogy.validation.ValueOfEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record RelationDTORequest(
        @Schema(description = "Unique identifier of the Relation.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long id,
        @Schema(description = "The first person id to whom the relationship relates", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull Long person1,
        @Schema(description = "The second person id to whom the relationship relates", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull Long person2,
        @Schema(description = "Type of Relation: person1 -> person2.", example = "mother", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull @ValueOfEnum(enumClass = RelationType.class)
        String relationType1,
        @Schema(description = "Type of Relation: person2 -> person1.", example = "children", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull @ValueOfEnum(enumClass = RelationType.class)
        String relationType2,
        @Schema(description = "Comments to Relation.", example = "second MARRIAGE")
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