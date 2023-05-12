package pl.coderslab.genealogy.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {
    @Override
    public EventDTOResponse find(Long id) {
        return null;
    }

    @Override
    public List<EventDTOResponse> findAll() {
        return null;
    }

    @Override
    public EventDTOResponse update(EventDTORequest event) {
        return null;
    }

    @Override
    public EventDTOResponse create(EventDTORequest event) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
