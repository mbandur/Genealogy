package pl.coderslab.genealogy.document;

import pl.coderslab.genealogy.validation.ValueOfEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record DocumentDTORequest(
        Long id,
        @NotNull Long person1,
        @NotNull
        @ValueOfEnum(enumClass = DocumentType.class)
        String documentType,
        @Size(max = 255, message = "Max size = 255")
        String comments
) {
    public DocumentDTORequest withId(Long id) {
        return new DocumentDTORequest(id, person1(), documentType(), comments());
    }
}