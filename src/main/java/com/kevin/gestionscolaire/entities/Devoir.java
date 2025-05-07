package com.kevin.gestionscolaire.entities;
import com.kevin.gestionscolaire.entities.user.Teacher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "devoir")
public class Devoir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime dateCreated;
    private LocalDateTime dueDate;
    private Boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher createdBy;

    @ManyToOne
    @JoinColumn(name = "cours_id")
    private Course cours;
}

