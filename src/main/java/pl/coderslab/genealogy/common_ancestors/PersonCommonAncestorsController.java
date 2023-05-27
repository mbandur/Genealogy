package pl.coderslab.genealogy.common_ancestors;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.genealogy.person.PersonDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/ancestors")
public class PersonCommonAncestorsController {
    private final PersonCommonAncestorsService personCommonAncestorsService;

    @Operation(summary = "Find common ancestors for person1 and person2", description = "Returns list of ancestors", tags = {"commonancestors"})
    @GetMapping("/{id1}/{id2}/{range}")
    public List<PersonDTO> find(@PathVariable Long id1, @PathVariable Long id2, @PathVariable Long range) {
        List<PersonDTO> personDTOList = personCommonAncestorsService.find(id1, id2, range);
        log.debug("Finded common Ancestors: {}", personDTOList);
        return personDTOList;
    }
}