package com.hainguyen.note.controller;

import com.hainguyen.note.model.Note;
import com.hainguyen.note.model.NoteType;
import com.hainguyen.note.service.NoteService;
import com.hainguyen.note.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteTypeService noteTypeService;

    @ModelAttribute("noteTypes")
    public Iterable<NoteType> noteTypes() {
        return noteTypeService.findAll();
    }

    @ModelAttribute("note")
    public Note noteForm() {
        return new Note();
    }

    @GetMapping(value = {"/list", "/"})
    public ModelAndView listNote(@PageableDefault(size = 3, sort = "title") Pageable pageable,
                                 @RequestParam(defaultValue = "0") int page,
                                 @RequestParam("search") Optional<String> search,
                                 @RequestParam("noteType") Optional<Integer> noteType,
                                 HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("note/list");
        if (search.isPresent()) {
            modelAndView.addObject("notes", noteService.findAllByTitleContaining(search.get(), pageable));
        } else if (noteType.isPresent()) {
            modelAndView.addObject("notes", noteService.findAllByNoteTypeId(noteType.get(), pageable));
        } else {
            modelAndView.addObject("notes", noteService.findAll(pageable));
        }

        String uri = uriSearchAndPaging(request);
        modelAndView.addObject("myUrl", uri);
        modelAndView.addObject("currentPage", page);
        return modelAndView;
    }

    public String uriSearchAndPaging(HttpServletRequest request){
        String uri = String.valueOf(request.getRequestURL());
        String rQuest = request.getQueryString();
        if (rQuest != null) {
            int index = rQuest.indexOf("&");
            System.out.println(index);
            if (index != -1) {
                System.out.println(rQuest.substring(0, index));
                uri += "?" + rQuest.substring(0, index);
            } else {
                uri += "?" + request.getQueryString();
            }
        } else {
            uri += "?note";
        }
        return uri;
    }

    @GetMapping("/create-note")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("note/create");
        modelAndView.addObject("note", new Note());
        return modelAndView;
    }

    @PostMapping("/create-note")
    public ModelAndView saveCreate(@Validated @ModelAttribute("note") Note note
            , RedirectAttributes attributes
            , BindingResult bindingResult) {
        ModelAndView modelAndView;
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("note/create");
        } else {
            noteService.save(note);
            modelAndView = new ModelAndView("redirect:/list");
            attributes.addFlashAttribute("message", "Create Note Successful");
        }
        return modelAndView;
    }

    @GetMapping("/edit-note/{id}")
    public ModelAndView editDelForm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("note/edit");
        modelAndView.addObject("note", noteService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit-note")
    public ModelAndView saveUpdate(@ModelAttribute("note") Note note) {
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("note/edit");
        modelAndView.addObject("message", "Update Note successful");
        return modelAndView;
    }

    @GetMapping("/delete-note/{id}")
    public ModelAndView deleteNote(@PathVariable("id") int id) {
        noteService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        return modelAndView;
    }

    @GetMapping("/detail-note/{id}")
    public ModelAndView detailNote(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("note/view");
        modelAndView.addObject("note", noteService.findById(id));
        return modelAndView;
    }
}
