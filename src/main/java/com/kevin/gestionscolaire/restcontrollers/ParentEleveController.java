package com.kevin.gestionscolaire.restcontrollers;

import com.kevin.gestionscolaire.dtos.UserDto;
import com.kevin.gestionscolaire.entities.EleveClasse;
import com.kevin.gestionscolaire.entities.ParentEleve;
import com.kevin.gestionscolaire.repositories.ParentEleveRepository;
import com.kevin.gestionscolaire.repositories.UserRepository;
import com.kevin.gestionscolaire.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/parent-eleve")
@RequiredArgsConstructor
public class ParentEleveController {

    @Autowired
    ParentEleveRepository parentEleveRepository;
    UserService userService;
    UserRepository userRepository;


    @GetMapping
    public ResponseEntity<List<ParentEleve>> getAllParentEleve(){
        return ResponseEntity.ok(parentEleveRepository.findAll());
    }

    @GetMapping(value = "/parent/{idEleve}")
    public ResponseEntity<UserDto> getParentsForEleve(@PathVariable Long idEleve) {
        List<ParentEleve> parentEleves = parentEleveRepository.findByEleve_Id(idEleve);
        return ResponseEntity.ok(userService.convertUserToUserDto(parentEleves.get(0).getParent()));
    }

    @GetMapping(value = "/eleve/{idParent}")
    public ResponseEntity<List<UserDto>> getEleveForParent(@PathVariable Long idParent){
        List<ParentEleve> parentEleves = parentEleveRepository.findByParent_Id(idParent);
        List<UserDto> userDtos = new ArrayList<>();
        parentEleves.forEach(parentEleve -> userDtos.add(userService.convertUserToUserDto(parentEleve.getEleve())));
        return ResponseEntity.ok(userDtos);
    }

    @PostMapping(value = "/addparent")
    public ResponseEntity<ParentEleve> addParentForEleve(@RequestBody UserDto eleveDto, @RequestBody UserDto parentDto){
        ParentEleve parentEleve = new ParentEleve();
        parentEleve.setEleve(userService.convertUserDtoToUser(eleveDto));
        parentEleve.setParent(userService.convertUserDtoToUser(parentDto));
        return ResponseEntity.ok(parentEleveRepository.save(parentEleve));
    }
    @PutMapping(value = "/updateparent/{idEleve}/{idParent}/{idParentEleve}")
    public ResponseEntity<ParentEleve> updateParentForEleve(@PathVariable Long idEleve, @PathVariable Long idParent, @PathVariable long idParentEleve){
        ParentEleve parentEleve = parentEleveRepository.findById(idParentEleve).orElseThrow(() -> new RuntimeException("ParentEleve not found with id : " + idParentEleve));
        parentEleve.setEleve(userRepository.findById(idEleve).orElseThrow(() -> new RuntimeException("Eleve not found with id : " + idEleve)));
        parentEleve.setParent(userRepository.findById(idParent).orElseThrow(() -> new RuntimeException("Parent not found with id : " + idParent)));
        return ResponseEntity.ok(parentEleveRepository.save(parentEleve));
    }

    @DeleteMapping(value = "/deleteparent/{idEleve}/{idParent}")
    public void deleteParentEleve(@PathVariable Long idEleve, @PathVariable Long idParent){
        List<ParentEleve> parentEleves = parentEleveRepository.findByEleve_IdAndParent_Id(idEleve, idParent);
        parentEleves.forEach(parentEleve -> parentEleveRepository.delete(parentEleve));
    }
}
