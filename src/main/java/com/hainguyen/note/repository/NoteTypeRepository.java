package com.hainguyen.note.repository;

import com.hainguyen.note.model.NoteType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteTypeRepository extends PagingAndSortingRepository<NoteType, Integer> {
}
