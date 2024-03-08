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

    public Event getEvent(int eventId) {
        var eventOptional = eventRepository.findById(eventId);
        if (eventOptional.isEmpty()) {
            return new Event();
        }
        return eventOptional.get();
    }

    public List<Event> getEvents() {
        List<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(event -> events.add(event));
        return events;
    }

    public List<Event> getEvents(boolean eventStatus) {
        List<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(event -> {
            if (event.getIsAvailable() == eventStatus) {
                events.add(event);
            }
        });
        return events;
    }

    public void saveEvent(Event event) {
        eventRepository.save(event);
    }

    public void updateEvent(int eventId, boolean status) {
        var eventOptional = eventRepository.findById(eventId);
        eventOptional.ifPresent(evt -> {
            evt.setIsAvailable(status);
        });
        eventRepository.save(eventOptional.get());
    }

    public void updateEvent(int eventId, String eventName) {
        var eventOptional = eventRepository.findById(eventId);
        eventOptional.ifPresent(evt -> {
            evt.setEventName(eventName);
        });
        eventRepository.save(eventOptional.get());
    }
}
