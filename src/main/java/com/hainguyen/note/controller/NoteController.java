package com.hainguyen.note.controller;

import com.hainguyen.note.model.Note;
import com.hainguyen.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    @ModelAttribute("note")
    public Note noteForm() {
        return new Note();
    }

    @GetMapping(value = {"/list", "/"})
    public ModelAndView listNote() {
        System.out.println("hello");
        ModelAndView modelAndView = new ModelAndView("note/list");
        modelAndView.addObject("notes", noteService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-note")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("note/create");
        modelAndView.addObject("note", new Note());
        return modelAndView;
    }

    @PostMapping("/create-note")
    public ModelAndView saveCreate(@ModelAttribute("note") Note note){
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        return modelAndView;
    }

    @GetMapping("/edit-note/{id}")
    public ModelAndView editDelForm(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("note/edit");
        modelAndView.addObject("note", noteService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit-note")
    public ModelAndView saveUpdate(@ModelAttribute("note") Note note){
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("note/edit");
        modelAndView.addObject("message", "Update Note successful");
        return modelAndView;
    }

    @GetMapping("/delete-note/{id}")
    public ModelAndView deleteNote(@PathVariable("id") int id){
        noteService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        return modelAndView;
    }
}
