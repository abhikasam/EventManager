package com.example.EventManager.controllers;

import com.example.EventManager.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class EventController {
    @Autowired
    private EventService eventService;

    @RequestMapping("/events")
    public String getEventsPage(Model model) {
        model.addAttribute("events", eventService.getEvents(true));
        return "events.html";
    }

    @RequestMapping(value = "/eventTypes", method = RequestMethod.POST)
    public ModelAndView eventTypes(Model model,
                                   @RequestParam(defaultValue = "true") boolean open) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("events", eventService.getEvents(open));
        return modelAndView;
    }

    @RequestMapping(value = "/saveEvent", method = RequestMethod.POST)
    public String saveEvent(Model model,
                            @RequestParam int eventId,
                            @RequestParam(defaultValue = "false") boolean open
    ) {
        eventService.saveEvent(eventId, open);
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("events", eventService.getEvents(!open));
        return "eventTypes";
    }
}
