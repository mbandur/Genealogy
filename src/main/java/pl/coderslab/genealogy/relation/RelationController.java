package pl.coderslab.genealogy.relation;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/relations")
public class RelationController {
    private final RelationService relationService;
    @Operation(summary = "Find Relation by ID", description = "Returns a single Relation", tags = {"relation"})
    @GetMapping("/{id}")
    public RelationDTOResponse find(@PathVariable Long id) {
        return relationService.find(id);
    }

    @Operation(summary = "Find all Relations", description = "Returns list of Relations", tags = {"relation"})
    @GetMapping
    public List<RelationDTOResponse> findAll() {
        return relationService.findAll();
    }

    @Operation(summary = "Create a new Relation", description = "Reutrns a new Relation", tags = {"relation"})
    @PostMapping
    public RelationDTOResponse create(@Valid @RequestBody RelationDTORequest relationDTORequest) {
        return relationService.create(relationDTORequest);
    }

    @Operation(summary = "Find Relation by ID and remove it", description = "Returns a finded Relation", tags = {"relation"})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        relationService.delete(id);
    }
}