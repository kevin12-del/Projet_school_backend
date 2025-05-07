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
@Table(name = "base_teacher")
@EqualsAndHashCode(callSuper = true)
public class Teacher extends BaseUser {
    private String speciality;
}
