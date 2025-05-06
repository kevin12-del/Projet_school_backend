package com.kevin.gestionscolaire.services;

import com.kevin.gestionscolaire.dtos.CourseDTO;
import com.kevin.gestionscolaire.entities.Course;
import com.kevin.gestionscolaire.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ModelMapper modelMapper;

    UserService userService;


    public List<CourseDTO> getAllCourses(){
        return courseRepository.findAll().stream()
                .map(course -> convertCourseToCourseDTO(course))
                .collect(Collectors.toList());
    }


    public Optional<CourseDTO> getCourseById(Long id) {
        return courseRepository.findById(id)
                .map(course -> convertCourseToCourseDTO(course));
    }

    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = convertCourseDTOToCourse(courseDTO);
        return convertCourseToCourseDTO(courseRepository.save(course));
    }



    public Optional<CourseDTO> updateCourse(CourseDTO courseDTO){
        Optional<Course> course = courseRepository.findById(courseDTO.getId());
        if (course.isPresent()) {
           return Optional.of(convertCourseToCourseDTO(courseRepository.save(convertCourseDTOToCourse(courseDTO))));
        } else {
            return Optional.empty();
        }
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public Course convertCourseDTOToCourse(CourseDTO courseDTO){
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setNom(courseDTO.getNom());
        course.setEnseignant(userService.convertUserDtoToUser(courseDTO.getEnseignant()));
        return course;
    }

    public CourseDTO convertCourseToCourseDTO(Course course){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setNom(course.getNom());
        courseDTO.setEnseignant(userService.convertUserToUserDto(course.getEnseignant()));
        return courseDTO;
    }
}
