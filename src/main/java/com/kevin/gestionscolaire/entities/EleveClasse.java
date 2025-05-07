package com.kevin.gestionscolaire.entities;

import com.kevin.gestionscolaire.entities.user.Student;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "eleves_classes")
public class EleveClasse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    private String anneeScolaire;


}

