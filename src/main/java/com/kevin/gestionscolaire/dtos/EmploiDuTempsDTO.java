package com.kevin.gestionscolaire.dtos;



import java.time.LocalTime;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmploiDuTempsDTO {

    private Long id;
    private CourseDTO course;
    private String jour;
    private LocalTime heureDebut;
    private LocalTime heureFin;
}
