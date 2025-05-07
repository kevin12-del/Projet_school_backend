package com.kevin.gestionscolaire.repositories.userrepos;

import com.kevin.gestionscolaire.entities.user.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BaseUserRepository extends JpaRepository<BaseUser, Long> {
    Optional<BaseUser> findByEmail(String email);
    List<BaseUser> findByRole(BaseUser.Role role);
}
