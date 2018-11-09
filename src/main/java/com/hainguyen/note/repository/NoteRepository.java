package com.hainguyen.note.repository;

import com.hainguyen.note.model.Note;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends PagingAndSortingRepository<Note, Integer> {
}
