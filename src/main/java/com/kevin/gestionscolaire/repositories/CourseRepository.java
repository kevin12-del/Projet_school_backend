package com.kevin.gestionscolaire.repositories;

import com.kevin.gestionscolaire.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByEnseignant_Id(Long enseignantId);
    List<Course> findByClasse_Id(Long classeId);
}

