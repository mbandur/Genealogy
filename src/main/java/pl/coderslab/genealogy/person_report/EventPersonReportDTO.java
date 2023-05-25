package pl.coderslab.genealogy.person_report;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record EventPersonReportDTO(
        @Schema(description = "Unique identifier of the Event.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long id,
        @Schema(description = "Event date.", example = "2002-02-01", requiredMode = Schema.RequiredMode.REQUIRED)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate eventDate,
        @Schema(description = "Type of Event.", example = "BIRTH", requiredMode = Schema.RequiredMode.REQUIRED)
        String eventType,
        @Schema(description = "Comments to Event.", example = "At 5 pm")
        String comments
) {
    public EventPersonReportDTO withId(Long id) {
        return new EventPersonReportDTO(id, eventDate(), eventType(), comments());
    }
}