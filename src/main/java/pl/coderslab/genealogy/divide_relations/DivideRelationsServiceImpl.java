package pl.coderslab.genealogy.divide_relations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.genealogy.person.Person;
import pl.coderslab.genealogy.relation.Relation;
import pl.coderslab.genealogy.relation.RelationRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DivideRelationsServiceImpl implements DivideRelationsService {
    private final RelationRepository relationRepository;
    private final DivideRelationsMapper divideRelationsMapper;

    public List<DivideRelationsDTO> findAllRelationsByPerson(Person person) {
        List<Relation> relationsByPerson1 = relationRepository.findRelationsById(person);
        List<Relation> relationsByPerson2 = relationRepository.findRelationsById2(person);
        List<DivideRelationsDTO> listDividerelationsDTO = new ArrayList<>();
        listDividerelationsDTO.addAll(divideRelationsMapper.mapToDTO1(relationsByPerson1));
        listDividerelationsDTO.addAll(divideRelationsMapper.mapToDTO2(relationsByPerson2));
        return listDividerelationsDTO;
    }
}