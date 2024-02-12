package com.example.EventManager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping(value={"","/","/home"})
    public String displayHomePage(){
        return "home.html";
    }
}
