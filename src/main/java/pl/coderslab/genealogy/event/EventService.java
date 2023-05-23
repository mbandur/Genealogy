package pl.coderslab.genealogy.event;

import java.util.List;

public interface EventService {
    EventDTOResponse find(Long id);

    List<EventDTOResponse> findAll();

    EventDTOResponse create(EventDTORequest event);

    boolean delete(Long id);
}
