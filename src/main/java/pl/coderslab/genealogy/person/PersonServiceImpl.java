package pl.coderslab.genealogy.person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.genealogy.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public PersonDTO find(Long id) {
        return personRepository.findById(id)
                .map(personMapper::mapToPersonDTO)
                .orElseThrow(() -> ResourceNotFoundException.forId(id.toString()));
    }

    @Override
    public List<PersonDTO> findAll() {
        return personRepository.findAll().stream()
                .map(personMapper::mapToPersonDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO create(PersonDTO personDTO) {
        Person person = personRepository.save(personMapper.mapFromPersonDTO(personDTO));
        return personMapper.mapToPersonDTO(person);
    }

    @Override
    public PersonDTO update(PersonDTO personDTO) {
        personRepository.findById(personDTO.id())
                .orElseThrow(() -> ResourceNotFoundException.forId(personDTO.id().toString()));
        Person personToSave = personMapper.mapFromPersonDTO(personDTO);
        return personMapper.mapToPersonDTO(personRepository.save(personToSave));
    }

    @Override
    public boolean delete(Long id) {
        personRepository.findById(id)
                .ifPresentOrElse(personRepository::delete,
                        () -> {
                            throw ResourceNotFoundException.forId(id.toString());
                        });
        return true;
    }
}