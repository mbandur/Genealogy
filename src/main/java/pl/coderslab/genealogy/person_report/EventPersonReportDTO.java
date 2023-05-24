package pl.coderslab.genealogy.person_report;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record EventPersonReportDTO(
        Long id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate eventDate,
        String eventType,
        String comments
) {
    public EventPersonReportDTO withId(Long id) {
        return new EventPersonReportDTO(id, eventDate(), eventType(), comments());
    }
}