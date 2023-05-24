package pl.coderslab.genealogy.event;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.genealogy.person.Person;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findEventByPerson1AndEventType(Person person, String eventType);

    List<Event> findEventByPerson1(Person personEntity);
}