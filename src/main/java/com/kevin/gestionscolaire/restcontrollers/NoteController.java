package com.kevin.gestionscolaire.restcontrollers;

import com.kevin.gestionscolaire.dtos.NoteDTO;
import com.kevin.gestionscolaire.entities.Note;
import com.kevin.gestionscolaire.repositories.NoteRepository;
import com.kevin.gestionscolaire.services.NoteService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {
    @Autowired
    private final NoteRepository noteRepository;
    NoteService noteService;

    @GetMapping
    public ResponseEntity<List<NoteDTO>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @GetMapping("/eleve/{eleveId}")
    public  ResponseEntity<List<NoteDTO>> getNotesByEleve(@PathVariable Long eleveId) {
        return ResponseEntity.ok(noteService.getNotesByEleveId(eleveId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDTO> getNoteById(@PathVariable Long id) {
        return  ResponseEntity.ok(noteService.getNoteById(id));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<NoteDTO>> getNotesByCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(noteService.getNotesByCourseId(courseId));
    }

    @PostMapping
    public ResponseEntity<NoteDTO> addNote(@RequestBody NoteDTO noteDTO) {
        return ResponseEntity.ok(noteService.createNote(noteDTO));
    }

    @PutMapping
    public ResponseEntity<NoteDTO> updateNote(@RequestBody NoteDTO noteDTO){
        return ResponseEntity.ok(noteService.updateNote(noteDTO));
    }

    @DeleteMapping( value = "/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }
}
