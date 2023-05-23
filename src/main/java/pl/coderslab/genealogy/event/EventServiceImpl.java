package pl.coderslab.genealogy.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.genealogy.exception.ResourceAlreadyExistException;
import pl.coderslab.genealogy.exception.ResourceNotFoundException;
import pl.coderslab.genealogy.person.Person;
import pl.coderslab.genealogy.person.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final PersonRepository personRepository;
    private final EventMapper eventMapper;

    @Override
    public EventDTOResponse find(Long id) {
        return eventRepository.findById(id)
                .map(eventMapper::mapToEventDTO)
                .orElseThrow(() -> ResourceNotFoundException.forId(id.toString()));
    }

    @Override
    public List<EventDTOResponse> findAll() {
        return eventRepository.findAll().stream()
                .map(eventMapper::mapToEventDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EventDTOResponse create(EventDTORequest eventDTORequest) {
        Person person1 = personRepository.findById(eventDTORequest.person1()).orElseThrow(() -> ResourceNotFoundException.forId(eventDTORequest.id().toString()));

        if (eventDTORequest.eventType().equals("BIRTH")
                || eventDTORequest.eventType().equals("DEATH")) {
            eventRepository.findEventByPerson1AndEventType(
                            person1, eventDTORequest.eventType())
                    .ifPresent(s -> {
                                throw ResourceAlreadyExistException.forId(
                                        s.getId().toString());
                            }
                    );
        }
        Event eventToSave = eventMapper.mapFromEventDTORequest(eventDTORequest, person1);
        Event event = eventRepository.save(eventToSave);
        return eventMapper.mapToEventDTO(event);
    }

    public boolean delete(Long id) {
        eventRepository.findById(id)
                .ifPresentOrElse(
                        eventRepository::delete,
                        () -> {
                            throw ResourceNotFoundException.forId(id.toString());
                        });
        return true;
    }
}