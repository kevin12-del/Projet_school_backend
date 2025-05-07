package com.kevin.gestionscolaire.dtos.userdto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String role;
    private String speciality;
}
