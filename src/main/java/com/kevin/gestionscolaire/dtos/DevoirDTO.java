package com.kevin.gestionscolaire.dtos;

import com.kevin.gestionscolaire.dtos.userdto.TeacherDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DevoirDTO {
    private Long id;

    private String title;
    private String description;
    private LocalDateTime dateCreated;
    private LocalDateTime dueDate;
    private Boolean isCompleted;
    private TeacherDTO createdBy;
    private CourseDTO cours;
}
