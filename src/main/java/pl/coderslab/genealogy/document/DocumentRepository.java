package pl.coderslab.genealogy.document;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.genealogy.person.Person;

import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    Optional<Document> findDocumentByPerson1AndDocumentType(
            Person person,
            DocumentType documentType);
}