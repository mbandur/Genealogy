package pl.coderslab.genealogy.document;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentService documentService;

    @GetMapping("/{id}")
    public DocumentDTOResponse find(@PathVariable Long id) {
        return documentService.find(id);
    }

    @GetMapping
    public List<DocumentDTOResponse> findAll() {
        return documentService.findAll();
    }

    @PostMapping
    public DocumentDTOResponse create(@Valid @RequestBody DocumentDTORequest documentDTORequest) {
        return documentService.create(documentDTORequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        documentService.delete(id);
    }
}