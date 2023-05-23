package pl.coderslab.genealogy.relation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.genealogy.exception.RelationAlreadyExistException;
import pl.coderslab.genealogy.exception.RelationBadException;
import pl.coderslab.genealogy.exception.ResourceNotFoundException;
import pl.coderslab.genealogy.divide_relations.DivideRelationsDTO;
import pl.coderslab.genealogy.divide_relations.DivideRelationsService;
import pl.coderslab.genealogy.person.Person;
import pl.coderslab.genealogy.person.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RelationServiceImpl implements RelationService {
    private final RelationRepository relationRepository;
    private final PersonRepository personRepository;
    private final RelationMapper relationMapper;
    private final DivideRelationsService divideRelationsService;

    @Override
    public RelationDTOResponse find(Long id) {
        return relationRepository.findById(id)
                .map(relationMapper::mapToRelationDTOResponse)
                .orElseThrow(() -> ResourceNotFoundException.forId(id.toString()));
    }

    @Override
    public List<RelationDTOResponse> findAll() {
        return relationRepository.findAll().stream()
                .map(relationMapper::mapToRelationDTOResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RelationDTOResponse create(RelationDTORequest relationDTORequest) {
        Person person1 = personRepository.findById(relationDTORequest.person1()).orElseThrow(() -> ResourceNotFoundException.forId(relationDTORequest.id().toString()));
        Person person2 = personRepository.findById(relationDTORequest.person2()).orElseThrow(() -> ResourceNotFoundException.forId(relationDTORequest.id().toString()));
        if (person1.getId() == person2.getId()) {
            throw RelationBadException.forIds(
                    person1.getId().toString(), person2.getId().toString()
            );
        }
        List<DivideRelationsDTO> divideRelationsDTOList = divideRelationsService.findAllRelationsByPerson(person1);
        divideRelationsDTOList.stream()
                .filter(f -> f.person2().getId() == person2.getId())
                .findFirst()
                .ifPresent(s -> {
                    throw RelationAlreadyExistException.forIds(
                            person1.getId().toString(), person2.getId().toString()
                    );
                });
        Relation relationToSave = relationMapper.mapFromRelationDTORequest(relationDTORequest, person1, person2);
        Relation relation = relationRepository.save(relationToSave);
        return relationMapper.mapToRelationDTOResponse(relation);
    }

    @Override
    public boolean delete(Long id) {
        relationRepository.findById(id)
                .ifPresentOrElse(
                        relationRepository::delete,
                        () -> {
                            throw ResourceNotFoundException.forId(id.toString());
                        });
        return true;
    }
}