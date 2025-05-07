package com.kevin.gestionscolaire.repositories;

import com.kevin.gestionscolaire.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByTeacher_Id(Long teacherId);
    List<Course> findByClasse_Id(Long classeId);
}

