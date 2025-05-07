package com.kevin.gestionscolaire.services.Interface;

import com.kevin.gestionscolaire.dtos.CourseDTO;
import com.kevin.gestionscolaire.entities.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<CourseDTO> getAllCourses();
    Optional<CourseDTO> getCourseById(Long id);
    CourseDTO createCourse(CourseDTO courseDTO);
    Optional<CourseDTO> updateCourse(CourseDTO courseDTO);
    void deleteCourse(Long id);
    CourseDTO convertCourseToCourseDTO(Course course);
    Course convertCourseDTOToCourse(CourseDTO courseDTO);
}
