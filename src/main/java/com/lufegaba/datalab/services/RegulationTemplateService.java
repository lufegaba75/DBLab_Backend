package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.regulations.Regulation;
import com.lufegaba.datalab.model.entities.regulations.RegulationTemplate;
import com.lufegaba.datalab.model.repositories.RegulationRepository;
import com.lufegaba.datalab.model.repositories.RegulationTemplateRepository;
import com.lufegaba.datalab.model.repositories.SampleTypeRepository;
import com.lufegaba.datalab.model.repositories.TemplateRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class RegulationTemplateService {

    private final RegulationTemplateRepository regulationTemplateRepository;
    private final RegulationRepository regulationRepository;
    private final TemplateRepository templateRepository;
    private final SampleTypeRepository sampleTypeRepository;

    public RegulationTemplate createRegulationTemplate (RegulationTemplate regulationTemplate) {
        var regulation = regulationTemplate.getRegulation();
        var template = regulationTemplate.getTemplate();
        var type = template.getType();

        if (type != null && !sampleTypeRepository.existsBySampleType(type.getSampleType())) {
            sampleTypeRepository.save(type);
        }
        template.setType(sampleTypeRepository.findBySampleType(type.getSampleType()));
        if (!templateRepository.existsByTemplateName(template.getTemplateName())) {
            templateRepository.save(template);
        }
        regulationTemplate.setTemplate(templateRepository.findByTemplateName(template.getTemplateName()));
        if (regulation != null && !regulationRepository.existsByShortName(regulation.getShortName())) {
            regulationRepository.save(regulation);
        }
        regulationTemplate.setRegulation(regulationRepository.findByShortName(regulation.getShortName()));

        return regulationTemplateRepository.save(regulationTemplate);
    }

    public List<RegulationTemplate> findAllRegulationTemplates () {
        return regulationTemplateRepository.findAll();
    }

    public RegulationTemplate findRegulationByid (Long id) {
        return regulationTemplateRepository.findById(id).orElseThrow();
    }

    public List<RegulationTemplate> findTemplatesByRegulation (Long id) {
        var regulation = regulationRepository.findById(id).orElseThrow();
        return regulationTemplateRepository.findByRegulation(regulation);
    }

    public void deleteRegulationById (Long id) {
        regulationTemplateRepository.deleteById(id);
    }
}
