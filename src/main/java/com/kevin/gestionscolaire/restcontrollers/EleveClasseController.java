package com.kevin.gestionscolaire.restcontrollers;


import com.kevin.gestionscolaire.entities.EleveClasse;
import com.kevin.gestionscolaire.repositories.EleveClasseRepository;
import com.kevin.gestionscolaire.services.Interface.ClasseService;
import com.kevin.gestionscolaire.services.Interface.user.BaseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eleve-classe")
@RequiredArgsConstructor
public class EleveClasseController {

    @Autowired
    EleveClasseRepository eleveClasseRepository;

    BaseUserService baseUserService;
    ClasseService classeService;

    @GetMapping
    public ResponseEntity<List<EleveClasse>> getAllEleveClasse(){
        return ResponseEntity.ok(eleveClasseRepository.findAll());
    }

    /*@PostMapping("/inscrit")
    public ResponseEntity<EleveClasse> inscritEleveClasse(@RequestBody BaseUserDto baseUserDto, @RequestBody ClasseDTO classeDto){
        EleveClasse eleveClasse = new EleveClasse();
        eleveClasse.setStudent((Student) baseUserService.convertUserDtoToUser(baseUserDto));
        eleveClasse.setClasse(classeService.convertClasseDTOToClasse(classeDto));
        eleveClasse.setAnneeScolaire(classeDto.getAnneeScolaire());

        return  ResponseEntity.ok(eleveClasseRepository.save(eleveClasse));

    }*/

    @GetMapping(value = "/{idEleve}")
    public ResponseEntity<List<EleveClasse>> getAllClasseByEleve(@PathVariable Long idEleve){
        return ResponseEntity.ok(eleveClasseRepository.findByStudent_Id(idEleve));
    }

    @DeleteMapping(value = "/desinscrit/{idEleve}/{idClasse}")
    public ResponseEntity<Void> desincritEleveClasse(@PathVariable Long idEleve, @PathVariable Long idClasse){
        List<EleveClasse> eleveClasses = eleveClasseRepository.findByStudent_IdAndClasse_Id(idEleve, idClasse);
        eleveClasses.forEach(eleveClasse -> eleveClasseRepository.delete(eleveClasse));
        return ResponseEntity.noContent().build();
    }
}
