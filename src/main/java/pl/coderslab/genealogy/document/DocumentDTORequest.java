package pl.coderslab.genealogy.document;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.coderslab.genealogy.validation.ValueOfEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record DocumentDTORequest(
        @Schema(description = "Unique identifier of the Document.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long id,
        @Schema(description = "The person id to whom the Document relates", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull Long person1,
        @Schema(description = "Type of Document.", example = "ID_DOCUMENT", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull @ValueOfEnum(enumClass = DocumentType.class)
        String documentType,
        @Schema(description = "Comments to Document.", example = "3 photos")
        @Size(max = 255, message = "Max size = 255")
        String comments
) {
    public DocumentDTORequest withId(Long id) {
        return new DocumentDTORequest(id, person1(), documentType(), comments());
    }
}