package pl.coderslab.genealogy.person_report;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.coderslab.genealogy.person.PersonDTO;

import java.util.List;
import java.util.Map;
import java.util.Set;

public record PersonReportDTO(
        PersonDTO personDTO,
        @Schema(description = "List of all Documents.")
        List<DocumentPersonReportDTO> documentsReportDTO,
        @Schema(description = "List of all Events.")
        List<EventPersonReportDTO> eventsReportDTO,
        @Schema(description = "List of all Relations")
        Map<String, Set<PersonDTO>> relationsMapDTO
) {
}