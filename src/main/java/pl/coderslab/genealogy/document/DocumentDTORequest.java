package pl.coderslab.genealogy.document;

import pl.coderslab.genealogy.validation.EnumPattern;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record DocumentDTORequest(
        Long id,
        @NotNull Long person1,
        @NotNull @EnumPattern(regexp = "^BIRTH_CERTIFICATE|MARRIAGE_CERTIFICATE|DEATH_CERTIFICATE|ID_DOCUMENT|OTHER_DOCUMENT$"
                , message = "Only: BIRTH_CERTIFICATE, MARRIAGE_CERTIFICATE,DEATH_CERTIFICATE,ID_DOCUMENT,OTHER_DOCUMENT value")
        DocumentType documentType,
        @Size(max = 255)
        String comments
) {
    public DocumentDTORequest withId(Long id) {
        return new DocumentDTORequest(id, person1(), documentType(), comments());
    }
}