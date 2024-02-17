package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.analysis.Template;
import com.lufegaba.datalab.model.entities.samples.SampleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long> {

    boolean existsByType (SampleType type);
    List<Template> findByType (SampleType type);
    boolean existsByTemplateName (String templateName);
    Template findByTemplateName (String templateName);
}
