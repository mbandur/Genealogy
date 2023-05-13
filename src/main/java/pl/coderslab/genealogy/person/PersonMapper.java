package pl.coderslab.genealogy.person;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO mapToPersonDTO(Person person);

    Person mapFromPersonDTO(PersonDTO personDTO);
}
