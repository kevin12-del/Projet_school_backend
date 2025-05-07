package com.kevin.gestionscolaire.repositories.userrepos;

import com.kevin.gestionscolaire.entities.user.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
