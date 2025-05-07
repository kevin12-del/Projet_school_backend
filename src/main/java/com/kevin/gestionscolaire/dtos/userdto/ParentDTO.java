package com.kevin.gestionscolaire.dtos.userdto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParentDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String role;
    private List<StudentDTO> children;

}
