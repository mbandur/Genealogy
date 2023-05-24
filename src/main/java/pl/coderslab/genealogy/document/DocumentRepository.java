package pl.coderslab.genealogy.document;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.genealogy.person.Person;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    Optional<Document> findDocumentByPerson1AndDocumentType(Person person, String documentType);

    List<Document> findDocumentByPerson1(Person personEntity);
}