package pl.coderslab.genealogy.event;

import java.util.List;

public interface EventService {
    EventDTOResponse find(Long id);

    List<EventDTOResponse> findAll();

    EventDTOResponse update(EventDTORequest event);

    EventDTOResponse create(EventDTORequest event);

    boolean delete(Long id);
}
