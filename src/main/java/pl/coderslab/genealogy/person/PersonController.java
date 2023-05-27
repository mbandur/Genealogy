package pl.coderslab.genealogy.person;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;
    private final Validator validator;

    @Operation(summary = "Find Person by ID", description = "Returns a single Person", tags = {"person"})
    @GetMapping("/{id}")
    public PersonDTO find(@PathVariable Long id) {
        PersonDTO personDTO = personService.find(id);
        log.debug("Finded Person: {}", personDTO);
        return personDTO;
    }

    @Operation(summary = "Find all People", description = "Returns list of People", tags = {"person"})
    @GetMapping
    public List<PersonDTO> findAll() {
        List<PersonDTO> personDTOList = personService.findAll();
        log.debug("Finded all Persons: {}", personDTOList);
        return personDTOList;
    }

    @Operation(summary = "Create a new Person", description = "Reutrns a new Person", tags = {"person"})
    @PostMapping
    public ResponseEntity<PersonDTO> create(@Valid @RequestBody PersonDTO person) {
        PersonDTO personDTO = personService.create(person);
        log.debug("Created Person: {}", personDTO);
        return new ResponseEntity<>(personDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Find Person by ID and update it", description = "Returns a updated Person", tags = {"person"})
    @PutMapping("/{id}")
    public PersonDTO update(@PathVariable Long id, @Valid @RequestBody PersonDTO person) {
        PersonDTO personDTO = personService.update(person.withId(id));
        log.debug("Updated Person: {}", personDTO);
        return personDTO;
    }

    @Operation(summary = "Find Person by ID and remove it", description = "Remove a finded Person", tags = {"person"})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
        log.debug("Deleted Person id: {}", id);
    }
}