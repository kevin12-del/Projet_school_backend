package com.kevin.gestionscolaire.repositories.userrepos;

import com.kevin.gestionscolaire.entities.user.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
