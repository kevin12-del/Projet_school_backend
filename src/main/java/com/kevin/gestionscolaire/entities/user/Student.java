package com.kevin.gestionscolaire.entities.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.EqualsAndHashCode;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "base_student")
@EqualsAndHashCode(callSuper = true)
public class Student extends BaseUser {
    private String matricule;
    private String level;
}
