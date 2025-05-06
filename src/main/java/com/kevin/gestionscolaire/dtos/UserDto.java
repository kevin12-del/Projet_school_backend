package com.kevin.gestionscolaire.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String role;

}

