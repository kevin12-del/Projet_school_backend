package com.kevin.gestionscolaire.repositories;

import com.kevin.gestionscolaire.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByEleve_Id(Long eleveId);
    List<Note> findByCourse_Id(Long courseId);
    List<Note> findByEleve_IdAndCourse_Id(Long eleveId, Long courseId);
}

