package com.kevin.gestionscolaire.dtos;
import com.kevin.gestionscolaire.dtos.userdto.TeacherDTO;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDTO {

    private Long id;
    private String nom;
    private TeacherDTO teacher;
    private ClasseDTO classe;
}
