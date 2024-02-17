package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.regulations.RegulationCriteria;
import com.lufegaba.datalab.model.entities.regulations.RegulationTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegulationCriteriaRepository extends JpaRepository<RegulationCriteria, Long> {

    List<RegulationCriteria> findByTemplate (RegulationTemplate template);
 }
