package com.kevin.gestionscolaire.dtos;

import java.util.List;

import com.kevin.gestionscolaire.dtos.userdto.StudentDTO;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClasseDTO {

    private Long id;

    private String nom;
    private String niveau;
    private String anneeScolaire;

    List<StudentDTO> students;
}
