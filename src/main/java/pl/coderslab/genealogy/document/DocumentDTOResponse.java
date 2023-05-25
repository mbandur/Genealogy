package pl.coderslab.genealogy.document;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.coderslab.genealogy.person.Person;

public record DocumentDTOResponse(
        @Schema(description = "Unique identifier of the Document.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long id,
        @Schema(description = "The person to whom the Document relates", requiredMode = Schema.RequiredMode.REQUIRED)
        Person person1,
        @Schema(description = "Type of Document.", example = "ID_DOCUMENT", requiredMode = Schema.RequiredMode.REQUIRED)
        String documentType,
        @Schema(description = "Comments to Document.", example = "3 photos")
        String comments
) {
    public DocumentDTOResponse withId(Long id) {
        return new DocumentDTOResponse(id, person1(), documentType(), comments());
    }
}