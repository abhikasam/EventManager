package com.example.EventManager.controllers;

import com.example.EventManager.store.model.Event;
import com.example.EventManager.store.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class EventController {
    @Autowired
    private EventService eventService;

    @RequestMapping("/events")
    public String getEventsPage() {
        return "events.html";
    }

    @RequestMapping("/getEvents")
    public ModelAndView getEvents(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("events", eventService.getEvents());
        return modelAndView;
    }
}
