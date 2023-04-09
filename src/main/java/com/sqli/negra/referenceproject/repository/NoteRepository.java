package com.sqli.negra.referenceproject.repository;

import com.sqli.negra.referenceproject.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}