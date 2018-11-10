package com.hainguyen.note.service;

import com.hainguyen.note.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NoteService {
    Page<Note> findAll(Pageable pageable);

    Note findById(Integer id);

    void save(Note note);

    void remove(Integer id);
}
