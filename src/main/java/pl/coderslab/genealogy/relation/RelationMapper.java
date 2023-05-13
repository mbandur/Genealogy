package pl.coderslab.genealogy.relation;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.coderslab.genealogy.person.Person;

@Mapper(componentModel = "spring")
public interface RelationMapper {
    RelationMapper INSTANCE = Mappers.getMapper(RelationMapper.class);

    RelationDTOResponse mapToRelationDTOResponse(Relation relation);

    Relation mapFromRelationDTOResponse(RelationDTOResponse relationDTOResponse);

    @Mapping(source = "relationDTORequest.id", target = "id")
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(source = "person1", target = "person1")
    @Mapping(source = "person2", target = "person2")
    @Mapping(source = "relationDTORequest.comments", target = "comments")
    Relation mapFromRelationDTORequest(
            RelationDTORequest relationDTORequest
            , Person person1
            , Person person2
    );
}