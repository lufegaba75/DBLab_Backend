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

        return analysisTemplateTechniqueRepository.save(analysisTemplateTechnique);
    }

    public List<AnalysisTemplateTechnique> getAllAnalysisTemplateTechniques () {
        return analysisTemplateTechniqueRepository.findAll();
    }

    public AnalysisTemplateTechnique findAnalysisTTById (Long id) {
        return analysisTemplateTechniqueRepository.findById(id).orElseThrow();
    }

    public List<AnalysisTemplateTechnique> findAnalysisTTByAnTemplate (Long id) {
        var analysisTemplate = analysisTemplateRepository.findById(id).orElseThrow();
        return analysisTemplateTechniqueRepository.findByAnalysisTemplate(analysisTemplate);
    }

    public void deleteAnalysisTemplateTechnique (Long id) {
        analysisTemplateTechniqueRepository.deleteById(id);
    }
}
