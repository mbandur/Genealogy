package pl.coderslab.genealogy.document;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.coderslab.genealogy.person.Person;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    DocumentDTOResponse mapToDocumentDTO(Document document);

    Document mapFromDocumentDTO(DocumentDTOResponse documentDTOResponse);

    @Mapping(source = "documentDTORequest.id", target = "id")
    @Mapping(source = "person1", target = "person1")
    @Mapping(source = "documentDTORequest.comments", target = "comments")
    Document mapFromDocumentDTORequest(
            DocumentDTORequest documentDTORequest
            , Person person1
    );
}