package pl.coderslab.genealogy.person_report;

import pl.coderslab.genealogy.person.PersonDTO;

import java.util.List;
import java.util.Map;
import java.util.Set;

public record PersonReportDTO(
        PersonDTO personDTO,
        List<DocumentPersonReportDTO> documentsReportDTO,
        List<EventPersonReportDTO> eventsReportDTO,
        Map<String, Set<PersonDTO>> relationsMapDTO
) {
}