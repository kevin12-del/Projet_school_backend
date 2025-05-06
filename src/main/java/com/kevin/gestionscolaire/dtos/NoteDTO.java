package com.kevin.gestionscolaire.dtos;

import com.kevin.gestionscolaire.entities.Course;
import com.kevin.gestionscolaire.entities.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteDTO {

    private Long id;
    private UserDto eleve;
    private CourseDTO course;
    private Double note;
    private LocalDate date;
}
