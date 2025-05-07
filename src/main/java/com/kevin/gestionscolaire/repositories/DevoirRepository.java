package com.kevin.gestionscolaire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kevin.gestionscolaire.entities.Devoir;
import org.springframework.stereotype.Repository;

@Repository
public interface DevoirRepository extends JpaRepository<Devoir, Long> {
}
