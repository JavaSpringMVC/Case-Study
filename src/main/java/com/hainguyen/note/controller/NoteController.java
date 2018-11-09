package com.hainguyen.note.controller;

import com.hainguyen.note.model.Note;
import com.hainguyen.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    @ModelAttribute("note")
    public Note noteForm() {
        return new Note();
    }

    @GetMapping("/list")
    public ModelAndView listNote() {
        System.out.println("hello");
        ModelAndView modelAndView = new ModelAndView("note/list");
        modelAndView.addObject("notes", noteService.findAll());
        return modelAndView;
    }
}
