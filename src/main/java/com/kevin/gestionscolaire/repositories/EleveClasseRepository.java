package com.kevin.gestionscolaire.repositories;

import com.kevin.gestionscolaire.entities.EleveClasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EleveClasseRepository extends JpaRepository<EleveClasse, Long> {
    List<EleveClasse> findByClasse_IdAndAnneeScolaire(Long classeId, String anneeScolaire);

    List<EleveClasse> findByStudent_Id(Long studentId);
    List<EleveClasse> findByStudent_IdAndClasse_Id(Long eleveId, Long classeId);
    void deleteById(Long id);
}

