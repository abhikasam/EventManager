package com.example.EventManager.controllers;

import com.example.EventManager.model.Event;
import com.example.EventManager.service.EventService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class EventController {
    @Autowired
    private EventService eventService;

    @RequestMapping("/events")
    public String getEventsPage(Model model) {
        return "events.html";
    }

    @RequestMapping(value = "/eventTypes", method = RequestMethod.POST)
    public ModelAndView eventTypes(Model model,
                                   @RequestParam(defaultValue = "true") boolean open) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("events", eventService.getEvents(open));
        return modelAndView;
    }

    @RequestMapping("/editEvent/{eventId}")
    public String editEvent(Model model, @PathVariable int eventId) {
        model.addAttribute("event", eventService.getEvent(eventId));
        return "editEvent.html";
    }

    @RequestMapping(value = "/saveEvent", method = RequestMethod.POST)
    public String saveEvent(Model model,
                            @Valid @ModelAttribute Event event, Errors errors) {
        if (errors.hasErrors())
            return "editEvent.html";
        eventService.saveEvent(event);
        return "redirect:/events";
    }

    @RequestMapping(value = "/updateEvent", method = RequestMethod.POST)
    public String updateEvent(Model model,
                              @RequestParam int eventId,
                              @RequestParam(defaultValue = "false") boolean open
    ) {
        eventService.updateEvent(eventId, open);
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("events", eventService.getEvents(!open));
        return "eventTypes";
    }
}
