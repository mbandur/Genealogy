package pl.coderslab.genealogy.person_report;

public interface PersonReportService {
    PersonReportDTO findAllDataByPersonId(Long id);
}