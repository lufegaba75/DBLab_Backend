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
        var regulationTemplate = regulationCriteria.getTemplate();
            var template = regulationTemplate.getTemplate();
                var type = template.getType();
            var regulation = regulationTemplate.getRegulation();
        var technique = regulationCriteria.getTechnique();
            var parameter = technique.getParameter();
            var species = parameter.getSpecies();

        if (species != null && speciesRepository.existsBySpeciesName(species.getSpeciesName())) {
            speciesRepository.save(species);
        }
        parameter.setSpecies(speciesRepository.findBySpeciesName(species.getSpeciesName()));
        if (parameter != null && parameterRepository.existsByParameterName(parameter.getParameterName())) {
            parameterRepository.save(parameter);
        }
        technique.setParameter(parameterRepository.findByParameterName(parameter.getParameterName()));
        if (technique != null && techniqueRepository.existsByTechniqueName(technique.getTechniqueName())) {
            techniqueRepository.save(technique);
        }
        if (regulation != null && !regulationRepository.existsByShortName(regulation.getShortName())) {
            regulationRepository.save(regulation);
        }
        if (type != null && sampleTypeRepository.existsBySampleType(type.getSampleType())) {
            sampleTypeRepository.save(type);
        }
        template.setType(sampleTypeRepository.findBySampleType(type.getSampleType()));
        if (template != null && templateRepository.existsByTemplateName(template.getTemplateName())) {
            templateRepository.save(template);
        }
        regulationTemplate.setRegulation(regulationRepository.findByShortName(regulation.getShortName()));
        regulationTemplate.setTemplate(templateRepository.findByTemplateName(template.getTemplateName()));
        if (regulationTemplate != null && regulationTemplateRepository.existsByRegulation(regulationTemplate.getRegulation())) {
            regulationTemplateRepository.save(regulationTemplate);
        }
        regulationCriteria.setTemplate(regulationTemplateRepository.findByRegulationTemplate(regulationTemplate.getRegulationTemplate()));
        regulationCriteria.setTechnique(techniqueRepository.findByTechniqueName(technique.getTechniqueName()));

        return regulationCriteriaRepository.save(regulationCriteria);
    }

    public List<RegulationCriteria> findAllRegulationCriteria () {
        return regulationCriteriaRepository.findAll();
    }

    public RegulationCriteria findRegulationCriteriaById (Long id) {
        return regulationCriteriaRepository.findById(id).orElseThrow();
    }

    public List<RegulationCriteria> findByRegulationTemplate (String regulationTemplate) {
        var template = regulationTemplateRepository.findByRegulationTemplate(regulationTemplate);
        return regulationCriteriaRepository.findByTemplate(template);
    }

    public void deleteRegulationCriteria (Long id) {
        regulationCriteriaRepository.deleteById(id);
    }


}
