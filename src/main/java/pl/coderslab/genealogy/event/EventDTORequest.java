package pl.coderslab.genealogy.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.coderslab.genealogy.validation.ValueOfEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public record EventDTORequest(
        Long id,
        @NotNull Long person1,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate eventDate,
        @NotNull
        @ValueOfEnum(enumClass = EventType.class)
        String eventType,
        @Size(max = 255, message = "Max size = 255")
        String comments
) {
    public EventDTORequest withId(Long id) {
        return new EventDTORequest(id, person1(), eventDate(), eventType(), comments());
    }
}