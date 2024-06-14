package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.analysis.SampleTemplate;
import com.lufegaba.datalab.model.entities.enumerations.SampleState;
import com.lufegaba.datalab.model.repositories.SampleRepository;
import com.lufegaba.datalab.model.repositories.SampleTemplateRepository;
import com.lufegaba.datalab.model.repositories.TemplateRepository;
import com.lufegaba.datalab.model.repositories.WorkerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class SampleTemplateService {

    private final SampleTemplateRepository sampleTemplateRepository;
    private final SampleRepository sampleRepository;
    private final TemplateRepository templateRepository;
    private final WorkerRepository workerRepository;

    public SampleTemplate createSampleTemplate (SampleTemplate sampleTemplate) {
        sampleTemplate.setAssignedAt(LocalDateTime.now());
        var sample = sampleTemplate.getSample();
        sample.setSampleState(SampleState.ASSIGNED);
        return sampleTemplateRepository.save(sampleTemplate);
    }

    public List<SampleTemplate> getAllSampleTemplates () {
        return sampleTemplateRepository.findAll();
    }

    public List<SampleTemplate> getSampleTemplatesByTemplate (Long id) {
        var template = templateRepository.findById(id).orElseThrow();
        return sampleTemplateRepository.findByTemplate(template);
    }

    public List<SampleTemplate> getSampleTemplateBySample (Long id) {
        var sample = sampleRepository.findById(id).orElseThrow();
        return sampleTemplateRepository.findBySample(sample);
    }

    public List<SampleTemplate> getSampleTemplateByWorker (Long id) {
        var worker = workerRepository.findById(id).orElseThrow();
        return sampleTemplateRepository.findByAssignedBy(worker);
    }

    public SampleTemplate getSampleTemplateById (Long id) {
        return sampleTemplateRepository.findById(id).orElseThrow();
    }

    public void deleteSampleTemplateById (Long id) {
        sampleTemplateRepository.deleteById(id);
    }
}
