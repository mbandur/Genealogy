package pl.coderslab.genealogy.name_nationality;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class NameNationalityServiceImpl implements NameNationalityService {

    @Override
    public CountriesDTO getNameNationality(String name) {
        final String url = String.format("https://api.nationalize.io/?name=%s", name);
        return new RestTemplate().getForObject(url, CountriesDTO.class);
    }
}