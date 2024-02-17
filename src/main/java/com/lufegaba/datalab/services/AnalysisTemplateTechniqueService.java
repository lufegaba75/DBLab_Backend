package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.analysis.AnalysisTemplate;
import com.lufegaba.datalab.model.entities.analysis.AnalysisTemplateTechnique;
import com.lufegaba.datalab.model.entities.analysis.Template;
import com.lufegaba.datalab.model.repositories.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class AnalysisTemplateTechniqueService {

    private AnalysisTemplateTechniqueRepository analysisTemplateTechniqueRepository;
    private AnalysisTemplateRepository analysisTemplateRepository;
    private TechniqueRepository techniqueRepository;
    private TemplateTechniqueRepository templateTechniqueRepository;
    private ParameterRepository parameterRepository;
    private SpeciesRepository speciesRepository;
    private TemplateRepository templateRepository;
    private SampleTypeRepository sampleTypeRepository;

    public AnalysisTemplateTechnique createATTechnique (AnalysisTemplateTechnique analysisTemplateTechnique) {
        var analysisTemplate = analysisTemplateTechnique.getAnalysisTemplate();
            var template = analysisTemplate.getTemplate();
                var type = template.getType();
        var templateTechnique = analysisTemplateTechnique.getTechnique();
            var template2 = templateTechnique.getTemplate();
                var type2 = template2.getType();
            var technique = templateTechnique.getTechnique();
                var parameter = technique.getParameter();
                    var species = parameter.getSpecies();


            if (!speciesRepository.existsBySpeciesName(species.getSpeciesName())) {
                speciesRepository.save(species);
            }
            parameter.setSpecies(speciesRepository.findBySpeciesName(species.getSpeciesName()));
            if (!parameterRepository.existsByParameterName(parameter.getParameterName())) {
                parameterRepository.save(parameter);
            }
            technique.setParameter(parameterRepository.findByParameterName(parameter.getParameterName()));
            if (!techniqueRepository.existsByTechniqueName(technique.getTechniqueName())) {
                techniqueRepository.save(technique);
            }
            templateTechnique.setTechnique(technique);

            if (type.equals(type2)) {
                if (!sampleTypeRepository.existsBySampleType(type.getSampleType())) {
                    sampleTypeRepository.save(type);
                }
                template.setType(sampleTypeRepository.findBySampleType(type.getSampleType()));
                template2.setType(sampleTypeRepository.findBySampleType(type.getSampleType()));
            } else {
                throw new RuntimeException();
            }
            if (template.equals(template2)) {
                if (!templateRepository.existsByTemplateName(template.getTemplateName())) {
                    templateRepository.save(template);
                }
                templateTechnique.setTemplate(templateRepository.findByTemplateName(template.getTemplateName()));
                analysisTemplate.setTemplate(templateRepository.findByTemplateName(template.getTemplateName()));
            } else {
                throw new RuntimeException();
            }

            templateTechnique.setTechnique(techniqueRepository.findByTechniqueName(technique.getTechniqueName()));
            if (!templateTechniqueRepository.existsByCode(templateTechnique.getCode())) {
                templateTechniqueRepository.save(templateTechnique);
            }
            analysisTemplateTechnique.setTechnique(templateTechniqueRepository.findByCode(templateTechnique.getCode()));

            template.setType(sampleTypeRepository.findBySampleType(type.getSampleType()));
            analysisTemplate.setTemplate(templateRepository.findByTemplateName(template.getTemplateName()));
            if (!analysisTemplateRepository.existsByDescription(analysisTemplate.getDescription())) {
                analysisTemplateRepository.save(analysisTemplate);
            }
            analysisTemplateTechnique.setAnalysisTemplate(analysisTemplateRepository.findByDescription(analysisTemplate.getDescription()));

        return analysisTemplateTechniqueRepository.save(analysisTemplateTechnique);
    }

    public List<AnalysisTemplateTechnique> getAllAnalysisTemplateTechniques () {
        return analysisTemplateTechniqueRepository.findAll();
    }

    public AnalysisTemplateTechnique findAnalysisTTById (Long id) {
        return analysisTemplateTechniqueRepository.findById(id).orElseThrow();
    }

    public List<AnalysisTemplateTechnique> findAnalysisTTByAnTemplate (String description) {
        var analysisTemplate = analysisTemplateRepository.findByDescription(description);
        return analysisTemplateTechniqueRepository.findByAnalysisTemplate(analysisTemplate);
    }

    public void deleteAnalysisTemplateTechnique (Long id) {
        analysisTemplateTechniqueRepository.deleteById(id);
    }
}
