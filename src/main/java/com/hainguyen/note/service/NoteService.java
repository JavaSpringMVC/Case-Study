package com.hainguyen.note.service;

import com.hainguyen.note.model.Note;

import java.util.List;

public interface NoteService {
    Iterable<Note> findAll();

    Note findById(Integer id);

    void save(Note note);

    void remove(Integer id);
}
