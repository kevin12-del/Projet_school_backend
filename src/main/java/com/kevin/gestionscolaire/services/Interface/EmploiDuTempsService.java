package com.kevin.gestionscolaire.services.Interface;

import com.kevin.gestionscolaire.dtos.EmploiDuTempsDTO;

import java.util.List;

public interface EmploiDuTempsService {
    List<EmploiDuTempsDTO> getAllEmploiDuTemps();
    EmploiDuTempsDTO createEmploiDuTemps(EmploiDuTempsDTO emploiDuTempsDTO);
    void deleteEmploiDuTemps(Long id);
    EmploiDuTempsDTO updateEmploiDuTemps(EmploiDuTempsDTO emploiDuTempsDTO);
    EmploiDuTempsDTO getEmploiDuTempsById(Long id);
    List<EmploiDuTempsDTO> getEmploiDuTempsByCourseId(Long id);
    List<EmploiDuTempsDTO> getEmploiDuTempsByJour(String jour);
    List<EmploiDuTempsDTO> getEmploiDuTempsByCourseByJour(String jour, Long id);
}
