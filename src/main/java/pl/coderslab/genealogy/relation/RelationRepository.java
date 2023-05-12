package pl.coderslab.genealogy.relation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.genealogy.person.Person;

import java.util.List;

public interface RelationRepository extends JpaRepository<Relation, Long> {

    @Query("select r from Relation r where r.person1 =?1")
    List<Relation> findRelationsById(Person personEntity);

    @Query("select r from Relation r where r.person2 =?1")
    List<Relation> findRelationsById2(Person personEntity);
}