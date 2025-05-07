package com.kevin.gestionscolaire.repositories.userrepos;

import com.kevin.gestionscolaire.entities.user.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
}
