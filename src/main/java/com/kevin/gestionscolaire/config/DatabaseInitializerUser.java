package com.kevin.gestionscolaire.config;

import com.kevin.gestionscolaire.entities.*;
import com.kevin.gestionscolaire.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Profile("dev")
@Configuration
@RequiredArgsConstructor
public class DatabaseInitializerUser {
    private final UserRepository userRepository;
    private final ParentEleveRepository parentEleveRepository;
    private final ClasseRepository classeRepository;
    private final CourseRepository courseRepository;
    private final EleveClasseRepository eleveClasseRepository;
    private final EmploiDuTempsRepository emploiDuTempsRepository;
    private final NoteRepository noteRepository;


    @Bean
    @Order(1)
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            // 2 Admins
            for (int i = 1; i <= 2; i++) {
                userRepository.save(User.builder()
                        .nom("Admin")
                        .prenom("User" + i)
                        .email("admin" + i + "@example.com")
                        .role(User.Role.ADMIN)
                        .build());
            }

            // 15 Enseignants
            for (int i = 1; i <= 15; i++) {
                userRepository.save(User.builder()
                        .nom("Enseignant")
                        .prenom("User" + i)
                        .email("enseignant" + i + "@example.com")
                        .role(User.Role.ENSEIGNANT)
                        .build());
            }

            // 50 Élèves
            for (int i = 1; i <= 50; i++) {
                userRepository.save(User.builder()
                        .nom("Eleve")
                        .prenom("User" + i)
                        .email("eleve" + i + "@example.com")
                        .role(User.Role.ELEVE)
                        .build());
            }

            // 20 Parents
            for (int i = 1; i <= 20; i++) {
                userRepository.save(User.builder()
                        .nom("Parent")
                        .prenom("User" + i)
                        .email("parent" + i + "@example.com")
                        .role(User.Role.PARENT)
                        .build());
            }
        };
    }

    @Bean
    @Order(2)
    CommandLineRunner initRelations() {
        return args -> {
            List<User> parents = userRepository.findByRole(User.Role.PARENT);
            List<User> eleves = userRepository.findByRole(User.Role.ELEVE);

            int eleveIndex = 0;
            int elevesPerParent = eleves.size() / parents.size(); // environ 2 élèves par parent

            for (User parent : parents) {
                for (int i = 0; i < elevesPerParent && eleveIndex < eleves.size(); i++) {
                    User eleve = eleves.get(eleveIndex++);
                    parentEleveRepository.save(ParentEleve.builder()
                            .parent(parent)
                            .eleve(eleve)
                            .build());
                }
            }
        };
    }

    @Bean
    @Order(3)
    CommandLineRunner initClasses() {
        return args -> {
            classeRepository.save(Classe.builder()
                    .nom("6ème A")
                    .niveau("6ème")
                    .anneeScolaire("2024-2025")
                    .build());

            classeRepository.save(Classe.builder()
                    .nom("5ème B")
                    .niveau("5ème")
                    .anneeScolaire("2024-2025")
                    .build());

            classeRepository.save(Classe.builder()
                    .nom("4ème C")
                    .niveau("4ème")
                    .anneeScolaire("2024-2025")
                    .build());

            classeRepository.save(Classe.builder()
                    .nom("3ème D")
                    .niveau("3ème")
                    .anneeScolaire("2024-2025")
                    .build());

            classeRepository.save(Classe.builder()
                    .nom("2nde A")
                    .niveau("2nde")
                    .anneeScolaire("2024-2025")
                    .build());

            classeRepository.save(Classe.builder()
                    .nom("1ère B")
                    .niveau("1ère")
                    .anneeScolaire("2024-2025")
                    .build());

            classeRepository.save(Classe.builder()
                    .nom("Terminale C")
                    .niveau("Terminale")
                    .anneeScolaire("2024-2025")
                    .build());
        };
    }

    @Bean
    @Order(4)
    CommandLineRunner initCourses() {
        return args -> {
            List<User> enseignants = userRepository.findByRole(User.Role.ENSEIGNANT);
            List<Classe> classes = classeRepository.findAll();

            // Préparer des noms de cours fixes pour les enseignants
            String[] coursNoms = {"Mathématiques", "Physique", "Français", "Histoire"};

            int enseignantIndex = 0;

            for (Classe classe : classes) {
                for (int i = 0; i < 4; i++) {
                    User enseignant = enseignants.get(enseignantIndex % enseignants.size());
                    String nomCours = coursNoms[i % coursNoms.length];

                    courseRepository.save(Course.builder()
                            .nom(nomCours)
                            .enseignant(enseignant)
                            .classe(classe)
                            .build());

                    enseignantIndex++;
                }
            }
        };
    }

    @Bean
    @Order(5)
    CommandLineRunner initEleveClasses() {
        return args -> {
            List<User> eleves = userRepository.findByRole(User.Role.ELEVE);
            List<Classe> classes = classeRepository.findAll();

            int eleveIndex = 0;
            int elevesPerClasse = eleves.size() / classes.size(); // environ 7 élèves par classe
            String anneeScolaire = "2024-2025";

            for (Classe classe : classes) {
                for (int i = 0; i < elevesPerClasse && eleveIndex < eleves.size(); i++) {
                    User eleve = eleves.get(eleveIndex++);
                    eleveClasseRepository.save(EleveClasse.builder()
                            .eleve(eleve)
                            .classe(classe)
                            .anneeScolaire(anneeScolaire)
                            .build());
                }
            }
        };
    }

    @Bean
    @Order(6)
    CommandLineRunner initEmploiDuTemps() {
        return args -> {
            List<Classe> classes = classeRepository.findAll();
            List<EmploiDuTemps.Jour> jours = Arrays.asList(
                    EmploiDuTemps.Jour.LUNDI,
                    EmploiDuTemps.Jour.MARDI,
                    EmploiDuTemps.Jour.MERCREDI,
                    EmploiDuTemps.Jour.JEUDI,
                    EmploiDuTemps.Jour.VENDREDI
            );

            LocalTime[] heures = {
                    LocalTime.of(8, 0),
                    LocalTime.of(9, 30),
                    LocalTime.of(13, 0),
                    LocalTime.of(14, 30)
            };

            Random random = new Random();

            for (Classe classe : classes) {
                List<Course> courses = courseRepository.findByClasse_Id(classe.getId());

                for (EmploiDuTemps.Jour jour : jours) {
                    Course lastCourse = null;
                    int repeatCount = 0;

                    for (LocalTime heureDebut : heures) {
                        Course course;

                        do {
                            course = courses.get(random.nextInt(courses.size()));
                            if (lastCourse != null && course.equals(lastCourse)) {
                                repeatCount++;
                            } else {
                                repeatCount = 1;
                            }
                        } while (lastCourse != null && course.equals(lastCourse) && repeatCount > 2 && courses.size() > 1);

                        emploiDuTempsRepository.save(EmploiDuTemps.builder()
                                .course(course)
                                .jour(jour)
                                .heureDebut(heureDebut)
                                .heureFin(heureDebut.plusMinutes(90))
                                .build());

                        lastCourse = course;
                    }
                }
            }
        };
    }

    @Bean
    @Order(7)
    CommandLineRunner initNotes() {
        return args -> {
            Random random = new Random();

            // Récupérer tous les élèves
            List<User> eleves = userRepository.findByRole(User.Role.ELEVE);

            for (User eleve : eleves) {
                // Trouver les classes où est inscrit l’élève
                List<EleveClasse> eleveClasses = eleveClasseRepository.findByEleve_Id(eleve.getId());

                for (EleveClasse eleveClasse : eleveClasses) {
                    // Trouver les cours de la classe
                    List<Course> courses = courseRepository.findByClasse_Id(eleveClasse.getClasse().getId());

                    for (Course course : courses) {
                        // Générer une note aléatoire entre 5 et 20
                        double valeurNote = 5 + (15 * random.nextDouble());

                        // Créer et sauvegarder la note
                        noteRepository.save(Note.builder()
                                .eleve(eleve)
                                .course(course)
                                .note(Math.round(valeurNote * 10.0) / 10.0) // arrondi à 1 décimale
                                .date(LocalDate.now())
                                .build());
                    }
                }
            }
        };
    }
}
