package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.analysis.Parameter;
import com.lufegaba.datalab.model.entities.analysis.Technique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechniqueRepository extends JpaRepository<Technique, Long> {

    List<Technique> findByParameter (Parameter parameter);
    boolean existsByTechniqueName (String techniqueName);
    Technique findByTechniqueName (String techniqueName);
}
