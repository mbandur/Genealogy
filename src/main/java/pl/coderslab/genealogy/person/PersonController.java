package pl.coderslab.genealogy.person;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;
    private final Validator validator;

    @Operation(summary = "Find Person by ID", description = "Returns a single Person", tags = {"person"})
    @GetMapping("/{id}")
    public PersonDTO find(@PathVariable Long id) {
        return personService.find(id);
    }

    @Operation(summary = "Find all People", description = "Returns list of People", tags = {"person"})
    @GetMapping
    public List<PersonDTO> findAll() {
        return personService.findAll();
    }

    @Operation(summary = "Create a new Person", description = "Reutrns a new Person", tags = {"person"})
    @PostMapping
    public PersonDTO create(@Valid @RequestBody PersonDTO person) {
        return personService.create(person);
    }

    @Operation(summary = "Find Person by ID and update it", description = "Returns a updated Person", tags = {"person"})
    @PutMapping("/{id}")
    public PersonDTO update(@PathVariable Long id, @Valid @RequestBody PersonDTO person) {
        return personService.update(person.withId(id));
    }

    @Operation(summary = "Find Person by ID and remove it", description = "Remove a finded Person", tags = {"person"})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }
}