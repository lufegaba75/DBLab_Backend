package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.analysis.Technique;
import com.lufegaba.datalab.model.entities.analysis.Template;
import com.lufegaba.datalab.model.entities.analysis.TemplateTechnique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TemplateTechniqueRepository extends JpaRepository<TemplateTechnique, Long> {

    List<TemplateTechnique> findByTemplate (Template template);
    Optional<TemplateTechnique> findById (Long id);
    boolean existsByTemplate (Template template);
    boolean existsByTechnique (Technique technique);
    TemplateTechnique findByTemplateAndTechnique (Template template, Technique technique);
    boolean existsByCode (String code);
    TemplateTechnique findByCode (String code);

}
