package com.kevin.gestionscolaire.services.javaclass;

import com.kevin.gestionscolaire.dtos.ClasseDTO;
import com.kevin.gestionscolaire.dtos.userdto.StudentDTO;
import com.kevin.gestionscolaire.entities.Classe;
import com.kevin.gestionscolaire.entities.EleveClasse;
import com.kevin.gestionscolaire.repositories.ClasseRepository;
import com.kevin.gestionscolaire.repositories.EleveClasseRepository;
import com.kevin.gestionscolaire.services.Interface.ClasseService;
import com.kevin.gestionscolaire.services.Interface.user.BaseUserService;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClasseServiceImpl implements ClasseService {

    @Autowired
    ClasseRepository classeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    EleveClasseRepository eleveClasseRepository;

    BaseUserService baseUserService;


    public List<ClasseDTO> getAllClasses(){
        return classeRepository.findAll().stream()
                .map(classe -> convertClasseToClasseDTO(classe))
                .collect(Collectors.toList());
    }


    public Optional<ClasseDTO> getClasseById(Long id){
        return classeRepository.findById(id)
                .map(classe ->convertClasseToClasseDTO(classe));
    }


    public ClasseDTO createClasse(ClasseDTO classeDto) {
        Classe classe = convertClasseDTOToClasse(classeDto);
        return convertClasseToClasseDTO(classeRepository.save(classe));
    }

    /*public Optional<Classe> updateClasse(Long id, Classe updated) {
        return classeRepository.findById(id).map(classe -> {
            classe.setNom(updated.getNom());
            classe.setNiveau(updated.getNiveau());
            classe.setAnneeScolaire(updated.getAnneeScolaire());
            return classeRepository.save(classe);
        });
    }*/

    public Optional<ClasseDTO> updateClasse(ClasseDTO classeDTO){
        Optional<Classe> classe = classeRepository.findById(classeDTO.getId());
        if (classe.isPresent()) {
            classeRepository.save(convertClasseDTOToClasse(classeDTO));
            return Optional.ofNullable(convertClasseToClasseDTO(classe.orElseThrow(() -> new RuntimeException("Classe not found"))));
        } else {
            throw new RuntimeException("Classe not found");
        }
    }

    public void deleteClasse(Long id) {
        classeRepository.deleteById(id);
    }

    public List<StudentDTO> getEleveByClasse(Long id, String anneeScolaire){
        /*List<EleveClasse> elclass = eleveClasseRepository.findByClasse_IdAndAnneeScolaire(id, anneeScolaire);
        List<BaseUserDto> baseUserDtos = new ArrayList<>();
        elclass.forEach(eleveClasse -> {
            baseUserDtos.add(baseUserService.convertUserToUserDto(eleveClasse.getEleve()));
        });
        return baseUserDtos;*/
        return null;
    }

    public ClasseDTO convertClasseToClasseDTO(Classe classe){
        ClasseDTO classeDTO = new ClasseDTO();
        classeDTO.setId(classe.getId());
        classeDTO.setNom(classe.getNom());
        classeDTO.setNiveau(classe.getNiveau());
        classeDTO.setAnneeScolaire(classe.getAnneeScolaire());
        classeDTO.setStudents(getEleveByClasse(classe.getId(), classe.getAnneeScolaire()));
        return classeDTO;
    }

    public Classe convertClasseDTOToClasse(ClasseDTO classeDTO){
        Classe classe = new Classe();
        classe.setId(classeDTO.getId());
        classe.setNom(classeDTO.getNom());
        classe.setNiveau(classeDTO.getNiveau());
        classe.setAnneeScolaire(classeDTO.getAnneeScolaire());
        return classe;
    }
}
