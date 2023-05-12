package pl.coderslab.genealogy.document;

import java.util.List;

public interface DocumentService {
    DocumentDTOResponse find(Long id);

    List<DocumentDTOResponse> findAll();

    DocumentDTOResponse update(DocumentDTORequest document);

    DocumentDTOResponse create(DocumentDTORequest document);

    boolean delete(Long id);
}
