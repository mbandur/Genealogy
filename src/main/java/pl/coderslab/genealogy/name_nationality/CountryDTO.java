package pl.coderslab.genealogy.name_nationality;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CountryDTO(
        @Schema(description = "Country id.", example = "PL")
        String country_id,
        @Schema(description = "Country probability.", example = "0.67")
        double probability
) {
}