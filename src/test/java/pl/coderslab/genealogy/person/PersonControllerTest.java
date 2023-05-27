package pl.coderslab.genealogy.person;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("unit-test")
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @MockBean
    private PersonService personService;
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void givenPerson_whenGetByIdOfThatPerson_thenReturnThatPerson() throws Exception {
        PersonDTO personDTO = new PersonDTO(1L, "Mariusz", "Adam"
                , "Nowak", null, "M", "comments 1"
        );
        Mockito.when(personService.find(personDTO.id()))
                .thenReturn(personDTO);
        mockMvc.perform(MockMvcRequestBuilders.get("/persons/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personDTO)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .json(objectMapper
                                .writeValueAsString(
                                        new PersonDTO(1L, "Mariusz", "Adam"
                                                , "Nowak", null, "M", "comments 1"
                                        )
                                )
                        )
                );
    }

    @Test
    public void givenAllPerson_whenGetAllOfThatPerson_thenReturnThatAllPerson() throws Exception {
        List<PersonDTO> personDTOList = List.of(
                new PersonDTO(1L, "Mariusz", "Adam"
                        , "Nowak", null, "M", "comments 1"
                ),
                new PersonDTO(2L, "Anna", "Ewa"
                        , "Nowak", "Kowalska", "F", "comments 2"
                ));
        Mockito.when(personService.findAll()).thenReturn(personDTOList);
        mockMvc.perform(MockMvcRequestBuilders.get("/persons"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .json(objectMapper
                                .writeValueAsString(List.of(
                                        new PersonDTO(1L, "Mariusz", "Adam"
                                                , "Nowak", null, "M", "comments 1"
                                        ),
                                        new PersonDTO(2L, "Anna", "Ewa"
                                                , "Nowak", "Kowalska", "F", "comments 2"
                                        )))));
    }

    @Test
    public void givenNewPerson_whenCreate_thenSaveThatPerson() throws Exception {
        PersonDTO personDTO = new PersonDTO(null, "Mariusz", "Adam"
                , "Nowak", null, "M", "comments 1"
        );
        PersonDTO personDTOWithId = new PersonDTO(1L, "Mariusz", "Adam"
                , "Nowak", null, "M", "comments 1"
        );
        Mockito.when(personService.create(personDTO))
                .thenReturn(personDTOWithId);
        mockMvc.perform(MockMvcRequestBuilders.post("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personDTO)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content()
                        .json(objectMapper
                                .writeValueAsString(
                                        new PersonDTO(1L, "Mariusz", "Adam"
                                                , "Nowak", null, "M", "comments 1"
                                        )
                                )
                        )
                );
    }

    @Test
    public void givenExistingPerson_whenUpdateThatPerson_thenPersonHasNewData() throws Exception {
        PersonDTO personDTO = new PersonDTO(1L, "Mariusz", "Adam"
                , "Nowak", null, "M", "comments 1"
        );
        Mockito.when(personService.update(personDTO))
                .thenReturn(personDTO);
        mockMvc.perform(MockMvcRequestBuilders.put("/persons/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personDTO)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .json(objectMapper
                                .writeValueAsString(
                                        new PersonDTO(1L, "Mariusz", "Adam"
                                                , "Nowak", null, "M", "comments 1"
                                        )
                                )
                        )
                );
    }

    @Test
    public void givenPerson_whenDeleteByIdOfThatPerson_thenDeleteThatPerson() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.delete("/persons/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(personService, Mockito.times(1)).delete(1L);
    }
}