package pl.coderslab.genealogy.relation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import pl.coderslab.genealogy.document.DocumentRepository;
import pl.coderslab.genealogy.event.EventRepository;
import pl.coderslab.genealogy.person.PersonRepository;
import pl.coderslab.genealogy.relation.Relation;
import pl.coderslab.genealogy.relation.RelationRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("dev-local")
@DataJpaTest
@Sql(scripts = "/start.sql")
class RelationRepositoryTest {
    @Autowired
    TestEntityManager entityManager;
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    RelationRepository relationRepository;

    @Test
    void find_by_person1id_then_return_relations() {
        //when
        List<Relation> relationList = relationRepository.findRelationsByPerson1Id(2L);
        //then
        assertEquals(1, relationList.size());
    }
    @Test
    void find_by_person2id_then_return_relations() {
        //when
        List<Relation> relationList = relationRepository.findRelationsByPerson2Id(2L);
        //then
        assertEquals(3, relationList.size());
    }
}