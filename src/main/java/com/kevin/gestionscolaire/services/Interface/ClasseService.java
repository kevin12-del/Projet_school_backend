package com.kevin.gestionscolaire.services.Interface;

import com.kevin.gestionscolaire.dtos.ClasseDTO;
import com.kevin.gestionscolaire.dtos.userdto.StudentDTO;
import com.kevin.gestionscolaire.entities.Classe;

import java.util.List;
import java.util.Optional;

public interface ClasseService {
    List<ClasseDTO> getAllClasses();
    Optional<ClasseDTO> getClasseById(Long id);
    ClasseDTO createClasse(ClasseDTO classeDTO);
    Optional<ClasseDTO> updateClasse(ClasseDTO classeDTO);
    void deleteClasse(Long id);
    List<StudentDTO> getEleveByClasse(Long id, String anneeScolaire);
    ClasseDTO convertClasseToClasseDTO(Classe classe);
    Classe convertClasseDTOToClasse(ClasseDTO classeDTO);
}
