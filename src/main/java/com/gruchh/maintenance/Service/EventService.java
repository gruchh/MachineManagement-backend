package com.gruchh.maintenance.Service;

import com.gruchh.maintenance.Entity.Event;

import java.util.List;

public interface EventService {

    void saveEvents(List<Event> eventList);

}
