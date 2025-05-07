package com.kevin.gestionscolaire.restcontrollers;

import com.kevin.gestionscolaire.repositories.ParentEleveRepository;
import com.kevin.gestionscolaire.repositories.userrepos.BaseUserRepository;
import com.kevin.gestionscolaire.services.Interface.user.BaseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parent-eleve")
@RequiredArgsConstructor
public class ParentEleveController {

    @Autowired
    ParentEleveRepository parentEleveRepository;
    BaseUserService baseUserService;
    BaseUserRepository baseUserRepository;


     /*@GetMapping
    public ResponseEntity<List<ParentEleve>> getAllParentEleve(){
        return ResponseEntity.ok(parentEleveRepository.findAll());
    }

   @GetMapping(value = "/parent/{idEleve}")
    public ResponseEntity<BaseUserDto> getParentsForEleve(@PathVariable Long idEleve) {
        List<ParentEleve> parentEleves = parentEleveRepository.findByEleve_Id(idEleve);
        return ResponseEntity.ok(baseUserService.convertUserToUserDto(parentEleves.get(0).getParent()));
    }

    @GetMapping(value = "/eleve/{idParent}")
    public ResponseEntity<List<BaseUserDto>> getEleveForParent(@PathVariable Long idParent){
        List<ParentEleve> parentEleves = parentEleveRepository.findByParent_Id(idParent);
        List<BaseUserDto> baseUserDtos = new ArrayList<>();
        parentEleves.forEach(parentEleve -> baseUserDtos.add(baseUserService.convertUserToUserDto(parentEleve.getEleve())));
        return ResponseEntity.ok(baseUserDtos);
    }

    @PostMapping(value = "/addparent")
    public ResponseEntity<ParentEleve> addParentForEleve(@RequestBody BaseUserDto eleveDto, @RequestBody BaseUserDto parentDto){
        ParentEleve parentEleve = new ParentEleve();
        parentEleve.setEleve(baseUserService.convertUserDtoToUser(eleveDto));
        parentEleve.setParent(baseUserService.convertUserDtoToUser(parentDto));
        return ResponseEntity.ok(parentEleveRepository.save(parentEleve));
    }
    @PutMapping(value = "/updateparent/{idEleve}/{idParent}/{idParentEleve}")
    public ResponseEntity<ParentEleve> updateParentForEleve(@PathVariable Long idEleve, @PathVariable Long idParent, @PathVariable long idParentEleve){
        ParentEleve parentEleve = parentEleveRepository.findById(idParentEleve).orElseThrow(() -> new RuntimeException("ParentEleve not found with id : " + idParentEleve));
        parentEleve.setEleve(baseUserRepository.findById(idEleve).orElseThrow(() -> new RuntimeException("Eleve not found with id : " + idEleve)));
        parentEleve.setParent(baseUserRepository.findById(idParent).orElseThrow(() -> new RuntimeException("Parent not found with id : " + idParent)));
        return ResponseEntity.ok(parentEleveRepository.save(parentEleve));
    }

    @DeleteMapping(value = "/deleteparent/{idEleve}/{idParent}")
    public void deleteParentEleve(@PathVariable Long idEleve, @PathVariable Long idParent){
        List<ParentEleve> parentEleves = parentEleveRepository.findByEleve_IdAndParent_Id(idEleve, idParent);
        parentEleves.forEach(parentEleve -> parentEleveRepository.delete(parentEleve));
    }*/
}
