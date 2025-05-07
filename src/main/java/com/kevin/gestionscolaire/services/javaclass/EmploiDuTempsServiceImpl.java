package com.kevin.gestionscolaire.services.javaclass;

import com.kevin.gestionscolaire.dtos.EmploiDuTempsDTO;
import com.kevin.gestionscolaire.entities.EmploiDuTemps;
import com.kevin.gestionscolaire.repositories.EmploiDuTempsRepository;
import com.kevin.gestionscolaire.services.Interface.CourseService;
import com.kevin.gestionscolaire.services.Interface.EmploiDuTempsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmploiDuTempsServiceImpl implements EmploiDuTempsService {

    @Autowired
    EmploiDuTempsRepository emploiDuTempsRepository;

    CourseService courseService;

    public List<EmploiDuTempsDTO> getAllEmploiDuTemps(){
       List<EmploiDuTemps> emploiDuTemps = emploiDuTempsRepository.findAll();
       return emploiDuTemps.stream()
               .map(this::converterToEmploiDuTempsDTO)
               .toList();
    }

    public EmploiDuTempsDTO getEmploiDuTempsById(Long id){
        return emploiDuTempsRepository.findById(id)
                .map(this::converterToEmploiDuTempsDTO)
                .orElse(null);
    }

    public List<EmploiDuTempsDTO> getEmploiDuTempsByCourseId(Long id){
        return emploiDuTempsRepository.findByCourse_Id(id)
                .stream()
                .map(this::converterToEmploiDuTempsDTO)
                .toList();
    }

    public List<EmploiDuTempsDTO> getEmploiDuTempsByJour(String jour){
        return emploiDuTempsRepository.findByJour(EmploiDuTemps.Jour.valueOf(jour))
                .stream()
                .map(this::converterToEmploiDuTempsDTO)
                .toList();
    }

    public List<EmploiDuTempsDTO> getEmploiDuTempsByCourseByJour(String jour, Long id){
        return emploiDuTempsRepository.findByCourse_IdAndJour(id, EmploiDuTemps.Jour.valueOf(jour))
                .stream()
                .toList();
    }

    public EmploiDuTempsDTO createEmploiDuTemps(EmploiDuTempsDTO emploiDuTempsDTO){
        return converterToEmploiDuTempsDTO(emploiDuTempsRepository.save(converterToEmploiDuTemps(emploiDuTempsDTO)));
    }

    public void deleteEmploiDuTemps(Long id){
        emploiDuTempsRepository.deleteById(id);
    }

    public EmploiDuTempsDTO updateEmploiDuTemps(EmploiDuTempsDTO emploiDuTempsDTO){
        Optional<EmploiDuTemps> emploiDuTemps = emploiDuTempsRepository.findById(emploiDuTempsDTO.getId());
        if (emploiDuTemps.isPresent()) {
            return converterToEmploiDuTempsDTO(emploiDuTempsRepository.save(converterToEmploiDuTemps(emploiDuTempsDTO)));
        } else {
            return null;
        }
    }



    public EmploiDuTemps converterToEmploiDuTemps(EmploiDuTempsDTO emploiDuTempsDTO){

        EmploiDuTemps emploiDuTemps = new EmploiDuTemps();

        emploiDuTemps.setId(emploiDuTempsDTO.getId());
        emploiDuTemps.setJour(EmploiDuTemps.Jour.valueOf(emploiDuTempsDTO.getJour()));
        emploiDuTemps.setHeureDebut(emploiDuTempsDTO.getHeureDebut());
        emploiDuTemps.setHeureFin(emploiDuTempsDTO.getHeureFin());
        emploiDuTemps.setCourse(courseService.getCourseById(emploiDuTempsDTO.getId())
                                             .map(courseService::convertCourseDTOToCourse)
                                             .orElse(null));

        return emploiDuTemps;

    }

    public EmploiDuTempsDTO converterToEmploiDuTempsDTO(EmploiDuTemps emploiDuTemps){
        EmploiDuTempsDTO emploiDuTempsDTO = new EmploiDuTempsDTO();
        emploiDuTempsDTO.setId(emploiDuTemps.getId());
        emploiDuTempsDTO.setJour(emploiDuTemps.getJour().toString());
        emploiDuTempsDTO.setHeureDebut(emploiDuTemps.getHeureDebut());
        emploiDuTempsDTO.setHeureFin(emploiDuTemps.getHeureFin());
        emploiDuTempsDTO.setCourse(courseService.convertCourseToCourseDTO(emploiDuTemps.getCourse()));
        return emploiDuTempsDTO;
    }
}
