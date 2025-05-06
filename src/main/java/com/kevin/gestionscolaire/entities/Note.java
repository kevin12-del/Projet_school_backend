package com.kevin.gestionscolaire.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "eleve_id")
    private User eleve;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private Double note;
    private LocalDate date;


}

