package com.example.EventManager.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception ex){
        ModelAndView model=new ModelAndView();
        model.setViewName("error");
        model.addObject("errorMsg",ex.getMessage());
        return model;
    }
}
