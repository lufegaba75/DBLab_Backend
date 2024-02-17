package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.regulations.Regulation;
import com.lufegaba.datalab.model.entities.regulations.RegulationTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegulationTemplateRepository extends JpaRepository<RegulationTemplate, Long> {

    List<RegulationTemplate> findByRegulation(Regulation regulation);
    boolean existsByRegulation (Regulation regulation);
    RegulationTemplate findByRegulationTemplate (String regulationTemplate);
}