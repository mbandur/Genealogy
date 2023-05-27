package pl.coderslab.genealogy.event;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    @Operation(summary = "Find Event by ID", description = "Returns a single Event", tags = {"event"})
    @GetMapping("/{id}")
    public EventDTOResponse find(@PathVariable Long id) {
        EventDTOResponse eventDTOResponse = eventService.find(id);
        log.debug("Finded Event id: {}", id);
        return eventDTOResponse;
    }

    @Operation(summary = "Find all Events", description = "Returns list of Events", tags = {"event"})
    @GetMapping
    public List<EventDTOResponse> findAll() {
        List<EventDTOResponse> eventDTOResponseList = eventService.findAll();
        log.debug("Finded all Events: {}", eventDTOResponseList.size());
        return eventDTOResponseList;
    }

    @Operation(summary = "Create a new Event", description = "Reutrns a new Event", tags = {"event"})
    @PostMapping
    public ResponseEntity<EventDTOResponse> create(@Valid @RequestBody EventDTORequest eventDTORequest) {
        EventDTOResponse eventDTOResponse = eventService.create(eventDTORequest);
        log.debug("Created Event: {}", eventDTOResponse.id());
        return new ResponseEntity<>(eventDTOResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Find Event by ID and remove it", description = "Remove a finded Event", tags = {"event"})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventService.delete(id);
        log.debug("Deleted Event id: {}", id);
    }
}