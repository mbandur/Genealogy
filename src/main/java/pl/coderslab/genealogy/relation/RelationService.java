package pl.coderslab.genealogy.relation;

import java.util.List;

public interface RelationService {
    RelationDTOResponse find(Long id);

    List<RelationDTOResponse> findAll();

    RelationDTOResponse create(RelationDTORequest relationDTORequest);

    boolean delete(Long id);
}
