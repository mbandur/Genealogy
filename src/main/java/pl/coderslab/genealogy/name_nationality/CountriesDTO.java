package pl.coderslab.genealogy.name_nationality;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CountriesDTO(
        @Schema(description = "First name.", example = "Steven")
        String name,
        @Schema(description = "List of countries.")
        @JsonProperty("country")
        CountryDTO[] countries
) {
}