package pl.coderslab.genealogy.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("unit-test")
class PersonServiceTest {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonMapper personMapper;
    @Autowired
    PersonService personService;
    @BeforeEach
    public void setup() {
        personRepository = Mockito.mock(PersonRepository.class);
        personMapper = Mockito.mock(PersonMapper.class);
        personService = new PersonServiceImpl(personRepository, personMapper);
    }


    @Test
    void whenFindPerson_success() {
        Person person = Mockito.mock(Person.class);
        PersonDTO personDTO = Mockito.mock(PersonDTO.class);
        Mockito.when(personRepository.findById(2L)).thenReturn(Optional.of(person));
        Mockito.when(personMapper.mapToPersonDTO(person))
                .thenReturn(personDTO);
        PersonDTO actual = personService.find(2L);
        assertEquals(personDTO, actual);
    }

    @Test
    void whenCreatePerson_success() {
        PersonDTO personDTOstart = Mockito.mock(PersonDTO.class);
        Person personBeforeSave = Mockito.mock(Person.class);
        Person personAfterSave = Mockito.mock(Person.class);
        PersonDTO personDTOEnd = Mockito.mock(PersonDTO.class);
        Mockito.when(personMapper.mapFromPersonDTO(personDTOstart))
                .thenReturn(personBeforeSave);
        Mockito.when(personRepository.save(personBeforeSave))
                .thenReturn(personAfterSave);
        Mockito.when(personMapper.mapToPersonDTO(personAfterSave))
                .thenReturn(personDTOEnd);
        PersonDTO actual = personService.create(personDTOstart);
        assertEquals(personDTOEnd, actual);
    }
}