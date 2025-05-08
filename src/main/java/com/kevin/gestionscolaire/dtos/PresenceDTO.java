package com.kevin.gestionscolaire.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PresenceDTO {
    private Long id;
    private Long studentId;
    private Long courseId;
    private LocalDate date;
    private String status;
    private String justification;

    // getters et setters
}
