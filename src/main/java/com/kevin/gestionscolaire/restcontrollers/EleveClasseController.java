package com.kevin.gestionscolaire.restcontrollers;


import com.kevin.gestionscolaire.dtos.ClasseDTO;
import com.kevin.gestionscolaire.dtos.UserDto;
import com.kevin.gestionscolaire.entities.Classe;
import com.kevin.gestionscolaire.entities.EleveClasse;
import com.kevin.gestionscolaire.entities.User;
import com.kevin.gestionscolaire.repositories.EleveClasseRepository;
import com.kevin.gestionscolaire.services.ClasseService;
import com.kevin.gestionscolaire.services.UserService;
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

    UserService userService;
    ClasseService classeService;

    @GetMapping
    public ResponseEntity<List<EleveClasse>> getAllEleveClasse(){
        return ResponseEntity.ok(eleveClasseRepository.findAll());
    }

    @PostMapping("/inscrit")
    public ResponseEntity<EleveClasse> inscritEleveClasse(@RequestBody UserDto userDto, @RequestBody ClasseDTO classeDto){
        EleveClasse eleveClasse = new EleveClasse();
        eleveClasse.setEleve(userService.convertUserDtoToUser(userDto));
        eleveClasse.setClasse(classeService.convertClasseDTOToClasse(classeDto));
        eleveClasse.setAnneeScolaire(classeDto.getAnneeScolaire());

        return  ResponseEntity.ok(eleveClasseRepository.save(eleveClasse));

    }

    @GetMapping(value = "/{idEleve}")
    public ResponseEntity<List<EleveClasse>> getAllClasseByEleve(@PathVariable Long idEleve){
        return ResponseEntity.ok(eleveClasseRepository.findByEleve_Id(idEleve));
    }

    @DeleteMapping(value = "/desinscrit/{idEleve}/{idClasse}")
    public ResponseEntity<Void> desincritEleveClasse(@PathVariable Long idEleve, @PathVariable Long idClasse){
        List<EleveClasse> eleveClasses = eleveClasseRepository.findByEleve_IdAndClasse_Id(idEleve, idClasse);
        eleveClasses.forEach(eleveClasse -> eleveClasseRepository.delete(eleveClasse));
        return ResponseEntity.noContent().build();
    }
}
