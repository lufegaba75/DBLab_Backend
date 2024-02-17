package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.analysis.AnalysisTemplate;
import com.lufegaba.datalab.model.entities.analysis.AnalysisTemplateTechnique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalysisTemplateTechniqueRepository extends JpaRepository<AnalysisTemplateTechnique, Long> {

    List<AnalysisTemplateTechnique> findByAnalysisTemplate (AnalysisTemplate analysisTemplate);
}
