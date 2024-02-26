package com.example.EventManager.store.service;

import java.util.ArrayList;
import java.util.List;

import com.example.EventManager.store.model.Event;
import com.example.EventManager.store.repository.EventRepository;
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
}
