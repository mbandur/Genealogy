package pl.coderslab.genealogy.relation;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.coderslab.genealogy.person.Person;

public record RelationDTOResponse(
        @Schema(description = "Unique identifier of the Relation.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long id,
        @Schema(description = "The first person to whom the relationship relates", requiredMode = Schema.RequiredMode.REQUIRED)
        Person person1,
        @Schema(description = "The second person to whom the relationship relates", requiredMode = Schema.RequiredMode.REQUIRED)
        Person person2,
        @Schema(description = "Type of Relation: person1 -> person2.", example = "mother", requiredMode = Schema.RequiredMode.REQUIRED)
        RelationType relationType1,
        @Schema(description = "Type of Relation: person2 -> person1.", example = "children", requiredMode = Schema.RequiredMode.REQUIRED)
        RelationType relationType2,
        @Schema(description = "Comments to Relation.", example = "second MARRIAGE")
        String comments
) {
    public RelationDTOResponse withId(Long id) {
        return new RelationDTOResponse(
                id,
                person1(),
                person2(),
                relationType1(),
                relationType2(),
                comments()
        );
    }
}