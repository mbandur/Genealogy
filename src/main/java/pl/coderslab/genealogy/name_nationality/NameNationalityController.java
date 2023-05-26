package pl.coderslab.genealogy.name_nationality;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/nation")
public class NameNationalityController {
    private final NameNationalityService nameNationalityService;

    @GetMapping("/{name}")
    public CountriesDTO getNameNationality(@PathVariable String name) {
        return nameNationalityService.getNameNationality(name);
    }
}