package pl.coderslab.genealogy.name_nationality;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/nationalityname")
public class NameNationalityController {
    private final NameNationalityService nameNationalityService;

    @GetMapping("/{name}")
    public CountriesDTO getNameNationality(@PathVariable String name) {
        CountriesDTO countriesDTO = nameNationalityService.getNameNationality(name);
        log.debug("Finded name nationality: {}", countriesDTO);
        return countriesDTO;
    }
}