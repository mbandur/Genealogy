package pl.coderslab.genealogy.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DocumentServiceImpl implements DocumentService {
    @Override
    public DocumentDTOResponse find(Long id) {
        return null;
    }

    @Override
    public List<DocumentDTOResponse> findAll() {
        return null;
    }

    @Override
    public DocumentDTOResponse update(DocumentDTORequest document) {
        return null;
    }

    @Override
    public DocumentDTOResponse create(DocumentDTORequest document) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
