package com.kevin.gestionscolaire.repositories;

import com.kevin.gestionscolaire.entities.user.ParentEleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentEleveRepository extends JpaRepository<ParentEleve, Long> {
    List<ParentEleve> findByParent_Id(Long parentId);
    List<ParentEleve> findByStudent_Id(Long eleveId);
    List<ParentEleve> findByStudent_IdAndParent_Id(Long eleveId, Long parentId);
}

