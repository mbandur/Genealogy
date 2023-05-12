package pl.coderslab.genealogy.divide_relations;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import pl.coderslab.genealogy.relation.Relation;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DivideRelationsMapper {
    DivideRelationsMapper INSTANCE = Mappers.getMapper(DivideRelationsMapper.class);

    @Named(value = "DTO1")
    @Mapping(source = "relationType2", target = "relationType1")
    DivideRelationsDTO mapToDTO1(Relation relation);

    @IterableMapping(qualifiedByName = "DTO1")
    @Mapping(source = "relationType2", target = "relationType1")
    List<DivideRelationsDTO> mapToDTO1(List<Relation> relations);

    @Named(value = "DTO2")
    @Mapping(source = "person2", target = "person1")
    @Mapping(source = "person1", target = "person2")
    @Mapping(source = "relationType1", target = "relationType1")
    DivideRelationsDTO mapToDTO2(Relation relation);

    @IterableMapping(qualifiedByName = "DTO2")
    @Mapping(source = "person2", target = "person1")
    @Mapping(source = "person1", target = "person2")
    @Mapping(source = "relationType1", target = "relationType1")
    List<DivideRelationsDTO> mapToDTO2(List<Relation> relations);
}