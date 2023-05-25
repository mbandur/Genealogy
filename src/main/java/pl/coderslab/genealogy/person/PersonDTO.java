package pl.coderslab.genealogy.person;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.coderslab.genealogy.validation.ValueOfEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public record PersonDTO(
        @Schema(description = "Unique identifier of the Person.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long id,
        @Schema(description = "First name of the Person.", example = "John", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull @Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻa-ząćęłńóśźż]{3,20}$", message = "must match A-Ż between 3 and 20 characters}")
        String firstName,
        @Schema(description = "Second name of the Person.", example = "Steven")
        @Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻa-ząćęłńóśźż]{3,20}$", message = "must match A-Ż between 3 and 20 characters}")
        String secondName,
        @Schema(description = "Last name of the Person.", example = "Smith", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull @Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻa-ząćęłńóśźż-]{3,20}$", message = "must match A-Ż between 3 and 20 characters}")
        String lastName,
        @Schema(description = "Maiden name of the Person.", example = "Williams")
        @Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻa-ząćęłńóśźż-]{3,20}$", message = "must match A-Ż between 3 and 20 characters}")
        String maidenName,
        @Schema(description = "Sex.", example = "M", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull @ValueOfEnum(enumClass = Sex.class)
        String sex,
        @Schema(description = "Comments to Person.", example = "wear blinkers")
        @Size(max = 255, message = "Max size = 255")
        String comments
) {
    public PersonDTO withId(Long id) {
        return new PersonDTO(
                id,
                firstName(),
                secondName(),
                lastName(),
                maidenName(),
                sex(),
                comments()
        );
    }
}