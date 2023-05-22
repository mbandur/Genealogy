package pl.coderslab.genealogy.relation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/relations")
public class RelationController {
    private final RelationService relationService;

    @GetMapping("/{id}")
    public RelationDTOResponse find(@PathVariable Long id) {
        return relationService.find(id);
    }

    @GetMapping
    public List<RelationDTOResponse> findAll() {
        return relationService.findAll();
    }

    @PostMapping
    public RelationDTOResponse create(@Valid @RequestBody RelationDTORequest relationDTORequest) {
        return relationService.create(relationDTORequest);
    }

    @PutMapping("/{id}")
    public RelationDTOResponse update(@PathVariable Long id, @Valid @RequestBody RelationDTORequest relationDTORequest) {
        return relationService.update(relationDTORequest.withId(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        relationService.delete(id);
    }
}