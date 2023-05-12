package pl.coderslab.genealogy.relation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RelationServiceImpl implements RelationService {
    @Override
    public RelationDTOResponse find(Long id) {
        return null;
    }

    @Override
    public List<RelationDTOResponse> findAll() {
        return null;
    }

    @Override
    public RelationDTOResponse update(RelationDTORequest relationDTORequest) {
        return null;
    }

    @Override
    public RelationDTOResponse create(RelationDTORequest relationDTORequest) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
