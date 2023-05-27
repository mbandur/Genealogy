package pl.coderslab.genealogy.relation;

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
@RequestMapping("/relations")
public class RelationController {
    private final RelationService relationService;
    @Operation(summary = "Find Relation by ID", description = "Returns a single Relation", tags = {"relation"})
    @GetMapping("/{id}")
    public RelationDTOResponse find(@PathVariable Long id) {
        RelationDTOResponse relationDTOResponse =  relationService.find(id);
        log.debug("Finded Relation: {}", relationDTOResponse);
        return relationDTOResponse;
    }

    @Operation(summary = "Find all Relations", description = "Returns list of Relations", tags = {"relation"})
    @GetMapping
    public List<RelationDTOResponse> findAll() {
        List<RelationDTOResponse> relationDTOResponseList = relationService.findAll();
        log.debug("Finded all Relations: {}", relationDTOResponseList);
        return relationDTOResponseList;
    }

    @Operation(summary = "Create a new Relation", description = "Reutrns a new Relation", tags = {"relation"})
    @PostMapping
    public ResponseEntity<RelationDTOResponse> create(@Valid @RequestBody RelationDTORequest relationDTORequest) {
        RelationDTOResponse relationDTOResponse = relationService.create(relationDTORequest);
        log.debug("Deleted Relation: {}", relationDTOResponse);
        return new ResponseEntity<>(relationDTOResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Find Relation by ID and remove it", description = "Returns a finded Relation", tags = {"relation"})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        relationService.delete(id);
        log.debug("Deleted Relation id: {}", id);
    }
}