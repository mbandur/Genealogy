package pl.coderslab.genealogy.person_report;

public record DocumentPersonReportDTO(
        Long id,
        String documentType,
        String comments
) {
    public DocumentPersonReportDTO withId(Long id) {
        return new DocumentPersonReportDTO(id, documentType(), comments());
    }
}