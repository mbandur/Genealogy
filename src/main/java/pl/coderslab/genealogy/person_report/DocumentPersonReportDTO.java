package pl.coderslab.genealogy.person_report;

import io.swagger.v3.oas.annotations.media.Schema;

public record DocumentPersonReportDTO(
        @Schema(description = "Unique identifier of the Document.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long id,
        @Schema(description = "Type of Document.", example = "ID_DOCUMENT", requiredMode = Schema.RequiredMode.REQUIRED)
        String documentType,
        @Schema(description = "Comments to Document.", example = "3 photos")
        String comments
) {
    public DocumentPersonReportDTO withId(Long id) {
        return new DocumentPersonReportDTO(id, documentType(), comments());
    }
}