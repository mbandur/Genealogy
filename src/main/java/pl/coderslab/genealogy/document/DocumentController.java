package pl.coderslab.genealogy.document;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public DocumentDTOResponse create(@RequestBody DocumentDTORequest documentDTORequest) {
        return documentService.create(documentDTORequest);
    }

    @PutMapping("/{id}")
    public DocumentDTOResponse update(@PathVariable Long id, @RequestBody DocumentDTORequest documentDTORequest) {
        return documentService.update(documentDTORequest.withId(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        documentService.delete(id);
    }
}