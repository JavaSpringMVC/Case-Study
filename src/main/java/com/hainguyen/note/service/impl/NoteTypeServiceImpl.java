package com.hainguyen.note.service.impl;

import com.hainguyen.note.model.NoteType;
import com.hainguyen.note.repository.NoteTypeRepository;
import com.hainguyen.note.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "noteTypeService")
public class NoteTypeServiceImpl implements NoteTypeService {

    @Autowired
    NoteTypeRepository noteTypeRepository;

    @Override
    public Iterable<NoteType> findAll() {
        return noteTypeRepository.findAll();
    }

    @Override
    public NoteType findById(Integer id) {
        return noteTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(NoteType noteType) {
        noteTypeRepository.save(noteType);
    }

    @Override
    public void remove(Integer id) {
        noteTypeRepository.deleteById(id);
    }
}
