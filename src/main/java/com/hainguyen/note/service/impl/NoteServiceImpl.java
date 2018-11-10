package com.hainguyen.note.service.impl;

import com.hainguyen.note.model.Note;
import com.hainguyen.note.repository.NoteRepository;
import com.hainguyen.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service("noteService")
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public Page<Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Page<Note> findAllByTitleContaining(String title, Pageable pageable) {
        return noteRepository.findAllByTitleContaining(title, pageable);
    }

    @Override
    public Page<Note> findAllByNoteTypeId(Integer id, Pageable pageable) {
        return noteRepository.findAllByNoteTypeId(id, pageable);
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
