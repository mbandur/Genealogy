package pl.coderslab.genealogy.document;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentService documentService;

    @Operation(summary = "Find Document by ID", description = "Returns a single Document", tags = {"document"})
    @GetMapping("/{id}")
    public DocumentDTOResponse find(@PathVariable Long id) {
        return documentService.find(id);
    }

    @Operation(summary = "Find all Documents", description = "Returns list of Documents", tags = {"document"})
    @GetMapping
    public List<DocumentDTOResponse> findAll() {
        return documentService.findAll();
    }

    @Operation(summary = "Create a new Document", description = "Reutrns a new Document", tags = {"document"})
    @PostMapping
    public DocumentDTOResponse create(@Valid @RequestBody DocumentDTORequest documentDTORequest) {
        return documentService.create(documentDTORequest);
    }

    @Operation(summary = "Find Document by ID and remove it", description = "Remove a finded Document", tags = {"document"})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        documentService.delete(id);
    }
}