package com.hainguyen.note.repository;

import com.hainguyen.note.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends PagingAndSortingRepository<Note, Integer> {
    Page<Note> findAllByTitleContaining(String title, Pageable pageable);
    Page<Note> findAllByNoteTypeId(Integer id, Pageable pageable);
}
