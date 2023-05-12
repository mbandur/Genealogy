package pl.coderslab.genealogy.person;

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

    @GetMapping("/{id}")
    public PersonDTO find(@PathVariable Long id) {
        return personService.find(id);
    }

    @GetMapping
    public List<PersonDTO> findAll() {
        List<PersonDTO> listPersonDTO = personService.findAll();
        return listPersonDTO;
    }

    @PostMapping
    public PersonDTO create(@Valid @RequestBody PersonDTO person) {
        return personService.create(person);
    }

    @PutMapping("/{id}")
    public PersonDTO update(@PathVariable Long id, @RequestBody PersonDTO person) {
        return personService.update(person.withId(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }
}