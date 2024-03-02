package com.example.EventManager.service;

import java.util.ArrayList;
import java.util.List;

import com.example.EventManager.model.Event;
import com.example.EventManager.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getEvents() {
        List<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(event -> events.add(event));
        return events;
    }

    public List<Event> getEvents(boolean eventStatus) {
        List<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(event -> {
            if (event.isAvailable() == eventStatus) {
                events.add(event);
            }
        });
        return events;
    }

    public void saveEvent(int eventId, boolean status) {
        var eventOptional = eventRepository.findById(eventId);
        eventOptional.ifPresent(evt -> {
            evt.setAvailable(status);
        });
        eventRepository.save(eventOptional.get());
    }
}
