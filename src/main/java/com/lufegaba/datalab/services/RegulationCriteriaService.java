package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.regulations.RegulationCriteria;
import com.lufegaba.datalab.model.repositories.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class RegulationCriteriaService {

    private final RegulationCriteriaRepository regulationCriteriaRepository;
    private final RegulationTemplateRepository regulationTemplateRepository;
    private final RegulationRepository regulationRepository;
    private final TechniqueRepository techniqueRepository;
    private final ParameterRepository parameterRepository;
    private final SpeciesRepository speciesRepository;
    private final TemplateRepository templateRepository;
    private final SampleTypeRepository sampleTypeRepository;

    public RegulationCriteria createRegulationCriteria (RegulationCriteria regulationCriteria) {
        return regulationCriteriaRepository.save(regulationCriteria);
    }

    public List<RegulationCriteria> findAllRegulationCriteria () {
        return regulationCriteriaRepository.findAll();
    }

    public RegulationCriteria findRegulationCriteriaById (Long id) {
        return regulationCriteriaRepository.findById(id).orElseThrow();
    }

    public List<RegulationCriteria> findByRegulationTemplate (Long id) {
        var template = regulationTemplateRepository.findById(id).orElseThrow();
        return regulationCriteriaRepository.findByTemplate(template);
    }

    public void deleteRegulationCriteria (Long id) {
        regulationCriteriaRepository.deleteById(id);
    }


}
