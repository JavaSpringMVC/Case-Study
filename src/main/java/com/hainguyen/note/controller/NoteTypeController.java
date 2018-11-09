package com.hainguyen.note.controller;

import com.hainguyen.note.model.NoteType;
import com.hainguyen.note.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/noteType")
public class NoteTypeController {
    @Autowired
    NoteTypeService noteTypeService;

    @GetMapping(value = {"/", "/list"})
    public ModelAndView listType() {
        Iterable<NoteType> noteTypes = noteTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("type/list");
        modelAndView.addObject("noteTypes", noteTypes);
        return modelAndView;
    }

    @GetMapping("/create-note-type")
    public ModelAndView createNoteType(){
        ModelAndView modelAndView = new ModelAndView("type/create");
        modelAndView.addObject("noteType", new NoteType());
        return modelAndView;
    }

    @PostMapping("/create-note-type")
    public ModelAndView saveCreateNoteType(@ModelAttribute("noteType") NoteType noteType){
        noteTypeService.save(noteType);
        ModelAndView modelAndView = new ModelAndView("type/create");
        modelAndView.addObject("message", "Create note type successful");
        return modelAndView;
    }

    @GetMapping("/edit-note-type/{id}")
    public ModelAndView editNoteType(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("type/edit");
        modelAndView.addObject("noteType", noteTypeService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit-note-type")
    public ModelAndView saveEditNoteType(@ModelAttribute("noteType") NoteType noteType){
        noteTypeService.save(noteType);
        ModelAndView modelAndView = new ModelAndView("type/edit");
        modelAndView.addObject("message", "Edit note type successful");
        return modelAndView;
    }

    @GetMapping("/delete-note-type/{id}")
    public String deleteNoteType(@PathVariable("id") int id, RedirectAttributes attributes){
        noteTypeService.remove(id);
        attributes.addFlashAttribute("message", "Delete note type successful");
        return "redirect:/noteType/";
    }
}
