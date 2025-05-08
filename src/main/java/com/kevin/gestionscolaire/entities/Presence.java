package com.kevin.gestionscolaire.entities;


import com.kevin.gestionscolaire.entities.user.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "presence")
public class Presence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private PresenceStatus status;  // Enum: PRESENT, ABSENT, LATE

    private String justification; // peut être null

    public enum PresenceStatus {
        PRESENT,
        ABSENT,
        LATE
    }
}

