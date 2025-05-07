package com.kevin.gestionscolaire.services.Interface;

import com.kevin.gestionscolaire.dtos.NoteDTO;

import java.util.List;

public interface NoteService {
    List<NoteDTO> getAllNotes();
    NoteDTO createNote(NoteDTO noteDTO);
    void deleteNote(Long id);
    NoteDTO updateNote(NoteDTO noteDTO);
    NoteDTO getNoteById(Long id);
    List<NoteDTO> getNotesByEleveId(Long eleveId);
    List<NoteDTO> getNotesByCourseId(Long courseId);
}
