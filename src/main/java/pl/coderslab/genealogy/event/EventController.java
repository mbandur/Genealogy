package pl.coderslab.genealogy.event;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    @GetMapping("/{id}")
    public EventDTOResponse find(@PathVariable Long id) {
        return eventService.find(id);
    }

    @GetMapping
    public List<EventDTOResponse> findAll() {
        return eventService.findAll();
    }

    @PostMapping
    public EventDTOResponse create(@Valid @RequestBody EventDTORequest eventDTORequest) {
        return eventService.create(eventDTORequest);
    }

    @PutMapping("/{id}")
    public EventDTOResponse update(@PathVariable Long id, @Valid @RequestBody EventDTORequest eventDTORequest) {
        return eventService.update(eventDTORequest.withId(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventService.delete(id);
    }
}