package com.kevin.gestionscolaire.restcontrollers;

import com.kevin.gestionscolaire.dtos.EmploiDuTempsDTO;
import com.kevin.gestionscolaire.repositories.EmploiDuTempsRepository;
import com.kevin.gestionscolaire.services.Interface.EmploiDuTempsService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emplois-du-temps")
@RequiredArgsConstructor
public class EmploiDuTempsController {
    private final EmploiDuTempsRepository emploiDuTempsRepository;
    EmploiDuTempsService emploiDuTempsService;

    @GetMapping
    public ResponseEntity<List<EmploiDuTempsDTO>> getAllEmploiDuTemps(){
        return ResponseEntity.ok(emploiDuTempsService.getAllEmploiDuTemps());
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<EmploiDuTempsDTO> getEmploiDuTempsById(@PathVariable Long id){
        return ResponseEntity.ok(emploiDuTempsService.getEmploiDuTempsById(id));
    }

    @GetMapping("/jour/{jour}")
    public ResponseEntity<List<EmploiDuTempsDTO>> getByJour(@PathVariable String jour) {
        return ResponseEntity.ok(emploiDuTempsService.getEmploiDuTempsByJour(jour));
    }

    @GetMapping( "/course/{courseId}/jour/{jour}")
    public ResponseEntity<List<EmploiDuTempsDTO>> getByCourseAndJour(@PathVariable Long courseId, @PathVariable String jour) {
        return ResponseEntity.ok(emploiDuTempsService.getEmploiDuTempsByCourseByJour(jour, courseId));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<EmploiDuTempsDTO>> getByCourse(@PathVariable Long courseId) {
        return  ResponseEntity.ok(emploiDuTempsService.getEmploiDuTempsByCourseId(courseId));
    }

    @PostMapping
    public ResponseEntity<EmploiDuTempsDTO> create(@RequestBody EmploiDuTempsDTO edt) {
        return ResponseEntity.ok(emploiDuTempsService.createEmploiDuTemps(edt));
    }

    @PutMapping
    public ResponseEntity<EmploiDuTempsDTO> update(@RequestBody EmploiDuTempsDTO edt) {
        return ResponseEntity.ok(emploiDuTempsService.updateEmploiDuTemps(edt));
    }

    @DeleteMapping( value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        emploiDuTempsService.deleteEmploiDuTemps(id);
        return ResponseEntity.noContent().build();
    }
}
