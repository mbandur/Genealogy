package pl.coderslab.genealogy.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.coderslab.genealogy.person.Person;

import java.time.LocalDate;

public record EventDTOResponse(
        Long id,
        Person person1,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate eventDate,
        String eventType,
        String comments
) {
    public EventDTOResponse withId(Long id) {
        return new EventDTOResponse(id, person1(), eventDate(), eventType(), comments());
    }
}