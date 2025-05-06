package com.kevin.gestionscolaire.repositories;

import com.kevin.gestionscolaire.entities.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
    List<Classe> findByAnneeScolaire(String anneeScolaire);
}
