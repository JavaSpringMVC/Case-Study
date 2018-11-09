package com.hainguyen.note.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/noteType")
public class NoteTypeController {
    @GetMapping(value = {"/", "/list"})
    public ModelAndView listType(){
        ModelAndView modelAndView = new ModelAndView("type/list");
        return modelAndView;
    }
}
