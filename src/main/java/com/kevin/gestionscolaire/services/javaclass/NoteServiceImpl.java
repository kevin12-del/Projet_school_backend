package com.kevin.gestionscolaire.services.javaclass;

import com.kevin.gestionscolaire.dtos.NoteDTO;
import com.kevin.gestionscolaire.entities.Note;
import com.kevin.gestionscolaire.repositories.NoteRepository;
import com.kevin.gestionscolaire.services.Interface.CourseService;
import com.kevin.gestionscolaire.services.Interface.NoteService;
import com.kevin.gestionscolaire.services.Interface.user.BaseUserService;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    ModelMapper modelMapper;

    BaseUserService baseUserService;
    CourseService courseService;



    public List<NoteDTO> getAllNotes(){
        return noteRepository.findAll().stream()
                .map(note -> convertNoteToNoteDTO(note))
                .collect(Collectors.toList());
    }

    public List<NoteDTO> getNotesByEleveId(Long eleveId){
        List<Note> notes = noteRepository.findByStudent_Id(eleveId);
        return notes.stream()
                .map(note -> convertNoteToNoteDTO(note))
                .collect(Collectors.toList());
    }

    public NoteDTO getNoteById(Long id){
        return convertNoteToNoteDTO(noteRepository.findById(id).get());
    }

    public List<NoteDTO> getNotesByCourseId(Long courseId){
        List<Note> notes = noteRepository.findByCourse_Id(courseId);
        return notes.stream()
                .map(note -> convertNoteToNoteDTO(note))
                .collect(Collectors.toList());
    }

    public NoteDTO updateNote(NoteDTO noteDTO){
        return convertNoteToNoteDTO(noteRepository.save(convertNoteDTOToNote(noteDTO)));
    }

    public NoteDTO createNote(NoteDTO noteDTO){
        return convertNoteToNoteDTO(noteRepository.save(convertNoteDTOToNote(noteDTO)));
    }
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }


    public Note convertNoteDTOToNote(NoteDTO noteDTO){
        /*Note note = new Note();
        note.setId(noteDTO.getId());
        note.setNote(noteDTO.getNote());
        note.setDate(noteDTO.getDate());
        note.setEleve(baseUserService.convertUserDtoToUser(noteDTO.getEleve()));
        note.setCourse(courseService.convertCourseDTOToCourse(noteDTO.getCourse()));

        return note;*/
        return null;
    }

    public NoteDTO convertNoteToNoteDTO(Note note){
        /*NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(note.getId());
        noteDTO.setNote(note.getNote());
        noteDTO.setDate(note.getDate());
        noteDTO.setEleve(baseUserService.convertUserToUserDto(note.getEleve()));
        noteDTO.setCourse(courseService.convertCourseToCourseDTO(note.getCourse()));

        return noteDTO;*/
        return null;
    }

}

