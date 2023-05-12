package pl.coderslab.genealogy.person;

import java.util.List;

public interface PersonService {
    PersonDTO find(Long id);

    List<PersonDTO> findAll();

    PersonDTO update(PersonDTO person);

    PersonDTO create(PersonDTO person);

    boolean delete(Long id);
}