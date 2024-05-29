package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.analysis.Template;
import com.lufegaba.datalab.model.entities.analysis.TemplateTechnique;
import com.lufegaba.datalab.model.entities.samples.SampleType;
import com.lufegaba.datalab.model.repositories.SampleTypeRepository;
import com.lufegaba.datalab.model.repositories.TechniqueRepository;
import com.lufegaba.datalab.model.repositories.TemplateRepository;
import com.lufegaba.datalab.model.repositories.TemplateTechniqueRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class TemplateTechniqueService {

    private final TemplateTechniqueRepository templateTechniqueRepository;
    private final TemplateRepository templateRepository;
    private final TechniqueRepository techniqueRepository;
    private final SampleTypeRepository sampleTypeRepository;

    public TemplateTechnique createNewTemplateTechnique (TemplateTechnique templateTechnique) {
        return templateTechniqueRepository.save(templateTechnique);
    }

    public List<TemplateTechnique> getAllTemplateTechniques () {
        return templateTechniqueRepository.findAll();
    }

    public TemplateTechnique findTemplateTechniqueById (Long id) {
        return templateTechniqueRepository.findById(id).orElseThrow();
    }

    public List<TemplateTechnique> findAllByTemplate (Long templateId) {
        var template = templateRepository.findById(templateId).orElseThrow();
        return templateTechniqueRepository.findByTemplate(template);
    }

    public void deleteById (Long id) {
        templateTechniqueRepository.deleteById(id);
    }

}
