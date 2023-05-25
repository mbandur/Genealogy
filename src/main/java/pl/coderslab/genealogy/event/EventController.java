package pl.coderslab.genealogy.event;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    @Operation(summary = "Find Event by ID", description = "Returns a single Event", tags = {"event"})
    @GetMapping("/{id}")
    public EventDTOResponse find(@PathVariable Long id) {
        return eventService.find(id);
    }

    @Operation(summary = "Find all Events", description = "Returns list of Events", tags = {"event"})
    @GetMapping
    public List<EventDTOResponse> findAll() {
        return eventService.findAll();
    }

    @Operation(summary = "Create a new Event", description = "Reutrns a new Event", tags = {"event"})
    @PostMapping
    public EventDTOResponse create(@Valid @RequestBody EventDTORequest eventDTORequest) {
        return eventService.create(eventDTORequest);
    }

    @Operation(summary = "Find Event by ID and remove it", description = "Remove a finded Event", tags = {"event"})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventService.delete(id);
    }
}