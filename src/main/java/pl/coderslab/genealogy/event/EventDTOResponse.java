package pl.coderslab.genealogy.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import pl.coderslab.genealogy.person.Person;

import java.time.LocalDate;

public record EventDTOResponse(
        @Schema(description = "Unique identifier of the Event.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long id,
        @Schema(description = "The person to whom the Event relates", requiredMode = Schema.RequiredMode.REQUIRED)
        Person person1,
        @Schema(description = "Event date.", example = "2002-02-01", requiredMode = Schema.RequiredMode.REQUIRED)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate eventDate,
        @Schema(description = "Type of Event.", example = "BIRTH", requiredMode = Schema.RequiredMode.REQUIRED)
        String eventType,
        @Schema(description = "Comments to Event.", example = "At 5 pm")
        String comments
) {
    public EventDTOResponse withId(Long id) {
        return new EventDTOResponse(id, person1(), eventDate(), eventType(), comments());
    }
}