package com.kevin.gestionscolaire.repositories.userrepos;

import com.kevin.gestionscolaire.entities.user.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
