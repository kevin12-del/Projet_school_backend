package com.kevin.gestionscolaire.restcontrollers;

import com.kevin.gestionscolaire.dtos.ClasseDTO;
import com.kevin.gestionscolaire.repositories.ClasseRepository;
import com.kevin.gestionscolaire.services.Interface.ClasseService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/classes")
@RequiredArgsConstructor
public class ClasseController {
    private final ClasseRepository classeRepository;

    ClasseService classeService;

    @GetMapping
    public ResponseEntity<List<ClasseDTO>> getAllClasses() {
        return ResponseEntity.ok(classeService.getAllClasses());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClasseDTO> getClasseById(@PathVariable Long id) {
        return classeService.getClasseById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*@GetMapping(value = "/{id}/eleves")
    public ResponseEntity<List<BaseUserDto>> getElevesByClasse(@PathVariable Long id) {
        ClasseDTO classeDTO = classeService.getClasseById(id).orElse(null);
        if (classeDTO == null || classeDTO.getStudents() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(classeDTO.getStudents());
    }*/

    @PostMapping
    public ResponseEntity<ClasseDTO> createClasse(@RequestBody ClasseDTO classeDTO) {
        return ResponseEntity.ok(classeService.createClasse(classeDTO));
    }

    @PutMapping
    public ResponseEntity<ClasseDTO> updateClasse(@RequestBody ClasseDTO classeDTO){
        return classeService.updateClasse(classeDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping( value = "/{idClasse}")
    public ResponseEntity<Void> deleteClasse(@PathVariable Long idClasse){
        classeService.deleteClasse(idClasse);
        return ResponseEntity.noContent().build();
    }


}
