package com.kevin.gestionscolaire.dtos;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDTO {

    private Long id;
    private String nom;
    private UserDto enseignant;
    private ClasseDTO classe;
}
