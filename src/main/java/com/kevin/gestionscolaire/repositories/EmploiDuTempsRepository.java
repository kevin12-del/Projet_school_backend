package com.kevin.gestionscolaire.repositories;

import com.kevin.gestionscolaire.dtos.EmploiDuTempsDTO;
import com.kevin.gestionscolaire.entities.EmploiDuTemps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmploiDuTempsRepository extends JpaRepository<EmploiDuTemps, Long> {
    List<EmploiDuTemps> findByCourse_Id(Long courseId);
    List<EmploiDuTemps> findByJour(EmploiDuTemps.Jour jour);

    List<EmploiDuTempsDTO> findByCourse_IdAndJour(Long courseId, EmploiDuTemps.Jour jour);
}
