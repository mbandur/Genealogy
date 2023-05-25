package pl.coderslab.genealogy.relation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RelationRepository extends JpaRepository<Relation, Long> {

    @Query(value = "select * from relations where person1_id =?1", nativeQuery = true)
    List<Relation> findRelationsByPerson1Id(Long personId);

    @Query(value = "select * from relations where person2_id =?1", nativeQuery = true)
    List<Relation> findRelationsByPerson2Id(Long personId);
}