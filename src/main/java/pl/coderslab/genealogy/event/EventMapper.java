package pl.coderslab.genealogy.event;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.coderslab.genealogy.person.Person;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    EventDTOResponse mapToEventDTO(Event event);

    Event mapFromEventDTO(EventDTOResponse eventDTOResponse);

    @Mapping(source = "eventDTORequest.id", target = "id")
    @Mapping(source = "person1", target = "person1")
    @Mapping(source = "eventDTORequest.comments", target = "comments")
    Event mapFromEventDTORequest(
            EventDTORequest eventDTORequest
            , Person person1
    );
}