package com.hainguyen.note.service;

import com.hainguyen.note.model.NoteType;
import org.springframework.stereotype.Service;


public interface NoteTypeService {
    Iterable<NoteType> findAll();

    NoteType findById(Integer id);

    void save(NoteType noteType);

    void remove(Integer id);
}
