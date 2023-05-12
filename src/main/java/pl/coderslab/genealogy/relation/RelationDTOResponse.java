package pl.coderslab.genealogy.relation;

import pl.coderslab.genealogy.person.Person;

public record RelationDTOResponse(
        Long id,
        Person person1,
        Person person2,
        RelationType relationType1,
        RelationType relationType2,
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