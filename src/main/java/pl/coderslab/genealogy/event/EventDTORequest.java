package pl.coderslab.genealogy.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.coderslab.genealogy.validation.EnumPattern;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public record EventDTORequest(
        Long id,
        @NotNull Long person1,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate eventDate,
        @NotNull @EnumPattern(regexp = "^BIRTH|MARRIAGE|DEATH$", message = "Only: BIRTH, MARRIAGE, DEATH value")
        EventType eventType,
        @Size(max = 255)
        String comments
) {
    public EventDTORequest withId(Long id) {
        return new EventDTORequest(id, person1(), eventDate(), eventType(), comments());
    }
}