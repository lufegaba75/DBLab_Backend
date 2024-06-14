package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.analysis.AnalysisTemplate;
import com.lufegaba.datalab.model.repositories.AnalysisTemplateRepository;
import com.lufegaba.datalab.model.repositories.SampleTypeRepository;
import com.lufegaba.datalab.model.repositories.TemplateRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class AnalysisTemplateService {

    private final AnalysisTemplateRepository analysisTemplateRepository;
    private final TemplateRepository templateRepository;
    private final SampleTypeRepository sampleTypeRepository;

    public AnalysisTemplate createAnalysisTemplate (AnalysisTemplate analysisTemplate) {
        var template = analysisTemplate.getTemplate();
        var type = template.getType();

        if(!sampleTypeRepository.existsBySampleType(type.getSampleType())) {
            sampleTypeRepository.save(type);
        }
        template.setType(sampleTypeRepository.findBySampleType(type.getSampleType()));
        if (!templateRepository.existsByTemplateName(template.getTemplateName())) {
            templateRepository.save(template);
        }
        analysisTemplate.setTemplate(templateRepository.findByTemplateName(template.getTemplateName()));
        return analysisTemplateRepository.save(analysisTemplate);
    }

    public List<AnalysisTemplate> findAllAnalysisTemplates () {
        return analysisTemplateRepository.findAll();
    }

    public AnalysisTemplate findAnalysisTemplateById (Long id) {
        return analysisTemplateRepository.findById(id).orElseThrow();
    }

    public List<AnalysisTemplate> findAnalysisTemplateByTemplate (Long id) {
        var template = templateRepository.findById(id).orElseThrow();
        return analysisTemplateRepository.findAllByTemplate(template);
    }

    public AnalysisTemplate activateDeactivateAnalysisTemplate (Long id) {
        var analysisTemplate = findAnalysisTemplateById(id);
        analysisTemplate.setActive(!analysisTemplate.isActive());
        return analysisTemplate;
    }

    public void deleteAnalysisTemplate (Long id) {
        analysisTemplateRepository.deleteById(id);
    }


}
