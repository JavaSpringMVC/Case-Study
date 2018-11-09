package com.hainguyen.note.service.impl;

import com.hainguyen.note.model.Note;
import com.hainguyen.note.repository.NoteRepository;
import com.hainguyen.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("noteService")
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public Iterable<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note findById(Integer id) {
        return noteRepository.findById(id).get();
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void remove(Integer id) {
        noteRepository.deleteById(id);
    }
}
