package pl.coderslab.genealogy.name_nationality;

import org.springframework.web.bind.annotation.PathVariable;

public interface NameNationalityService {
    CountriesDTO getNameNationality(@PathVariable String name);
}
