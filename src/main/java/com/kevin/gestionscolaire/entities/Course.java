package com.kevin.gestionscolaire.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private User enseignant;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

}

