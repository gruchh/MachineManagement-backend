package com.gruchh.maintenance.Service;

import com.gruchh.maintenance.Entity.Event;
import com.gruchh.maintenance.Repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public void saveEvents(List<Event> eventList) {
        eventRepository.saveAll(eventList);

    }


}
