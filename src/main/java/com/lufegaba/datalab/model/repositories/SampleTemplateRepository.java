package com.lufegaba.datalab.model.repositories;


import com.lufegaba.datalab.model.entities.analysis.SampleTemplate;
import com.lufegaba.datalab.model.entities.analysis.Template;
import com.lufegaba.datalab.model.entities.samples.Sample;
import com.lufegaba.datalab.model.entities.users.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SampleTemplateRepository extends JpaRepository<SampleTemplate, Long> {

    List<SampleTemplate> findByTemplate(Template template);
    List<SampleTemplate> findBySample(Sample sample);
    List<SampleTemplate> findByAssignedBy(Worker assignedBy);

}
