package pl.coderslab.genealogy.person;

import pl.coderslab.genealogy.validation.EnumPattern;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public record PersonDTO(
        Long id,
        @Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻa-ząćęłńóśźż-]{3,20}$", message = "must match A-Ż between 3 and 20 characters}")
        String firstName,
        @Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻa-ząćęłńóśźż-]{3,20}$", message = "must match A-Ż between 3 and 20 characters}")
        String secondName,
        @Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻa-ząćęłńóśźż-]{3,20}$", message = "must match A-Ż between 3 and 20 characters}")
        String lastName,
        @Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻa-ząćęłńóśźż-]{3,20}$", message = "must match A-Ż between 3 and 20 characters}")
        String maidenName,
        @NotNull @EnumPattern(regexp = "^M|F$", message = "Only M or F value")
        Sex sex,
        @Size(max = 255)
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