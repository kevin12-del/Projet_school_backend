package com.kevin.gestionscolaire.restcontrollers.user;

import com.kevin.gestionscolaire.entities.user.Student;
import com.kevin.gestionscolaire.repositories.userrepos.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
