package com.kevin.gestionscolaire.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserDto {
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String role;
}
