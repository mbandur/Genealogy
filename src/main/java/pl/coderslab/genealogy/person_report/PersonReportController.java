package pl.coderslab.genealogy.person_report;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class PersonReportController {
    private final PersonReportService personReportService;

    @GetMapping("/{id}")
    public PersonReportDTO find(@PathVariable Long id) {
        return personReportService.findAllDataByPersonId(id);
    }
}