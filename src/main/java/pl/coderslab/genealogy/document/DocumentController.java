package pl.coderslab.genealogy.document;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentService documentService;

    @Operation(summary = "Find Document by ID", description = "Returns a single Document", tags = {"document"})
    @GetMapping("/{id}")
    public DocumentDTOResponse find(@PathVariable Long id) {
        DocumentDTOResponse documentDTOResponse = documentService.find(id);
        log.debug("Finded Document id: {}", id);
        return documentDTOResponse;
    }

    @Operation(summary = "Find all Documents", description = "Returns list of Documents", tags = {"document"})
    @GetMapping
    public List<DocumentDTOResponse> findAll() {
        List<DocumentDTOResponse> documentDTOResponseList = documentService.findAll();
        log.debug("Finded all Documents: {}", documentDTOResponseList.size());
        return documentDTOResponseList;
    }

    @Operation(summary = "Create a new Document", description = "Reutrns a new Document", tags = {"document"})
    @PostMapping
    public ResponseEntity<DocumentDTOResponse> create(@Valid @RequestBody DocumentDTORequest documentDTORequest) {
        DocumentDTOResponse documentDTOResponse = documentService.create(documentDTORequest);
        log.debug("Created Document id: {}", documentDTOResponse.id());
        return new ResponseEntity<>(documentDTOResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Find Document by ID and remove it", description = "Remove a finded Document", tags = {"document"})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        documentService.delete(id);
        log.debug("Deleted Document id: {}", id);
    }
}