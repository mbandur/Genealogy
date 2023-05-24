package pl.coderslab.genealogy.common_ancestors;

import pl.coderslab.genealogy.person.PersonDTO;

import java.util.List;

public interface PersonCommonAncestorsService {
       List<PersonDTO> find(Long id1, Long id2, Long range);
}
