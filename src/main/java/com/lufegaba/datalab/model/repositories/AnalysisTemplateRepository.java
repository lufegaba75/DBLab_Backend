package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.analysis.AnalysisTemplate;
import com.lufegaba.datalab.model.entities.analysis.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnalysisTemplateRepository extends JpaRepository<AnalysisTemplate, Long> {

    Optional<AnalysisTemplate> findById (Long id);
    List<AnalysisTemplate> findAllByTemplate (Template template);
    boolean existsByDescription (String description);
    AnalysisTemplate findByDescription (String description);
}
