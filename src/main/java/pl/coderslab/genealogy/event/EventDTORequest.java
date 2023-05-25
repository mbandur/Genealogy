package pl.coderslab.genealogy.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import pl.coderslab.genealogy.validation.ValueOfEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public record EventDTORequest(
        @Schema(description = "Unique identifier of the Event.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long id,
        @Schema(description = "The person id to whom the Event relates", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull Long person1,
        @Schema(description = "Event date.", example = "2002-02-01", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull
        @PastOrPresent
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate eventDate,
        @Schema(description = "Type of Event.", example = "BIRTH", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull         @ValueOfEnum(enumClass = EventType.class)
        String eventType,
        @Schema(description = "Comments to Event.", example = "At 5 pm")
        @Size(max = 255, message = "Max size = 255")
        String comments
) {
    public EventDTORequest withId(Long id) {
        return new EventDTORequest(id, person1(), eventDate(), eventType(), comments());
    }
}