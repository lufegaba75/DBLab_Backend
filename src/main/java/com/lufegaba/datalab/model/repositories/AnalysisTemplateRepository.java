package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.analysis.AnalysisTemplate;
import com.lufegaba.datalab.model.entities.analysis.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalysisTemplateRepository extends JpaRepository<AnalysisTemplate, Long> {

    List<AnalysisTemplate> findByTemplate (Template template);
    boolean existsByDescription (String description);
    AnalysisTemplate findByDescription (String description);
}
