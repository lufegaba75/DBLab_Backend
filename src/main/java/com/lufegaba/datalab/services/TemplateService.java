package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.analysis.Template;
import com.lufegaba.datalab.model.repositories.SampleTypeRepository;
import com.lufegaba.datalab.model.repositories.TemplateRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class TemplateService {

    private final TemplateRepository templateRepository;
    private final SampleTypeRepository typeRepository;

    public Template createTemplate (Template template) {
        var type = template.getType();

        if (!typeRepository.existsBySampleType(type.getSampleType())) {
            typeRepository.save(type);
        } else {
            template.setType(typeRepository.findBySampleType(type.getSampleType()));
        }
        template.setActive(true);
        return templateRepository.save(template);
    }

    public List<Template> getAllTemplates () {
        return templateRepository.findAll();
    }

    public Template getTemplateById (Long id) {
        return templateRepository.findById(id).orElseThrow();
    }

    public List<Template> getTemplatesBySampleType (String sampletype) {
        var type = typeRepository.findBySampleType(sampletype);
        return templateRepository.findByType(type);
    }

    public Template ActivateDeactivateTemplate (Long id) {
        var templateToUpdate = getTemplateById(id);
        templateToUpdate.setActive(!templateToUpdate.isActive());
        return templateToUpdate;
    }

    public void deleteTemplate (Long id) {
        templateRepository.deleteById(id);
    }

}
