package com.kevin.gestionscolaire.dtos;

import java.time.LocalDate;

import com.kevin.gestionscolaire.dtos.userdto.StudentDTO;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteDTO {

    private Long id;
    private StudentDTO student;
    private CourseDTO course;
    private Double note;
    private LocalDate date;
}
