package com.kevin.gestionscolaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.kevin.gestionscolaire.entities.user", "com.kevin.gestionscolaire.entities"})
public class GestionScolaireBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionScolaireBackendApplication.class, args);
    }

}
