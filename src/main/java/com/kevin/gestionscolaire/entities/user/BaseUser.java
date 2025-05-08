package com.kevin.gestionscolaire.entities.user;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "base_user")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN, TEACHER, STUDENT, PARENT
    }


}
