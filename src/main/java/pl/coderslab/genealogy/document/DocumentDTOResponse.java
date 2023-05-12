package pl.coderslab.genealogy.document;

import pl.coderslab.genealogy.person.Person;

public record DocumentDTOResponse(
        Long id,
        Person person1,
        DocumentType documentType,
        String comments
) {
    public DocumentDTOResponse withId(Long id) {
        return new DocumentDTOResponse(id, person1(), documentType(), comments());
    }
}