package pl.coderslab.genealogy.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public PersonDTO find(Long id) {
        return null;
    }

    @Override
    public List<PersonDTO> findAll() {
        return null;
    }

    @Override
    public PersonDTO update(PersonDTO person) {
        return null;
    }

    @Override
    public PersonDTO create(PersonDTO person) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
