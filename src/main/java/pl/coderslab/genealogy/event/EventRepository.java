package pl.coderslab.genealogy.event;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.genealogy.person.Person;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findEventByPerson1AndEventType(
            Person person,
            EventType eventType);
}
