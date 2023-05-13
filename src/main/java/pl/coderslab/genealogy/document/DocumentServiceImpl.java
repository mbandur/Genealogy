package pl.coderslab.genealogy.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.genealogy.exception.ResourceAlreadyExistException;
import pl.coderslab.genealogy.exception.ResourceNotFoundException;
import pl.coderslab.genealogy.person.Person;
import pl.coderslab.genealogy.person.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final PersonRepository personRepository;
    private final DocumentMapper documentMapper;

    @Override
    @Transactional
    public DocumentDTOResponse find(Long id) {
        return documentRepository.findById(id)
                .map(documentMapper::mapToDocumentDTO)
                .orElseThrow(() -> ResourceNotFoundException.forId(id.toString()));
    }

    @Override
    public List<DocumentDTOResponse> findAll() {
        return documentRepository.findAll().stream()
                .map(documentMapper::mapToDocumentDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DocumentDTOResponse create(DocumentDTORequest documentDTORequest) {
        Person person1 = personRepository.findById(documentDTORequest.person1())
                .orElseThrow(() -> ResourceNotFoundException.forId(documentDTORequest.id().toString()));
        documentRepository.findDocumentByPerson1AndDocumentType(
                        person1, documentDTORequest.documentType())
                .ifPresent(s -> {
                            throw ResourceAlreadyExistException.forId(
                                    s.getId().toString());
                        }
                );
        Document documentToSave = documentMapper.mapFromDocumentDTORequest(documentDTORequest, person1);
        Document document = documentRepository.save(documentToSave);
        return documentMapper.mapToDocumentDTO(document);
    }

    @Override
    @Transactional
    public DocumentDTOResponse update(DocumentDTORequest documentDTORequest) {
        Person person1 = personRepository.findById(documentDTORequest.person1()).orElseThrow(() -> ResourceNotFoundException.forId(documentDTORequest.id().toString()));
        documentRepository.findById(documentDTORequest.id()).orElseThrow(() -> ResourceNotFoundException.forId(documentDTORequest.id().toString()));
        Document documentToSave = documentMapper.mapFromDocumentDTORequest(documentDTORequest, person1);
        Document document = documentRepository.save(documentToSave);
        return documentMapper.mapToDocumentDTO(document);
    }

    @Override
    public boolean delete(Long id) {
        documentRepository.findById(id)
                .ifPresentOrElse(
                        documentRepository::delete,
                        () -> {
                            throw ResourceNotFoundException.forId(id.toString());
                        });
        return true;
    }
}