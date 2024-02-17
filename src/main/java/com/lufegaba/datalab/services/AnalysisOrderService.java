package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.analysis.AnalysisOrder;
import com.lufegaba.datalab.model.entities.analysis.AnalysisTemplate;
import com.lufegaba.datalab.model.repositories.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Transactional
public class AnalysisOrderService {

    private final AnalysisOrderRepository analysisOrderRepository;
    private final SampleRepository sampleRepository;
    private final AnalysisTemplateRepository analysisTemplateRepository;
    private final TemplateRepository templateRepository;
    private final SampleTypeRepository sampleTypeRepository;
    private final SamplingRepository samplingRepository;
    private final ClientRepository clientRepository;
    private final PhoneRepository phoneRepository;
    private final AddressRepository addressRepository;
    private final WorkerRepository workerRepository;

    public AnalysisOrder createAnalysisOrder (AnalysisOrder analysisOrder) {
        var sample = analysisOrder.getSample();
            var sampling =  sample.getSampling();
            var sampleType = sample.getSampleType();
                var worker = sampling.getWorker();
                var client = sampling.getClient();
                    var address = client.getAddress();
                    var phone = client.getPhone();
        var analysisTemplate = analysisOrder.getAnalysisTemplate();
            var template = analysisTemplate.getTemplate();
                var sampleType2 = template.getType();

        if (phone != null && !phoneRepository.existsByPhoneNumber(phone.getPhoneNumber())) {
            phoneRepository.save(phone);
        }
        client.setPhone(phoneRepository.findByPhoneNumber(phone.getPhoneNumber()));
        if (address != null && !addressRepository.existsByFirstLine(address.getFirstLine())) {
            addressRepository.save(address);
        }
        client.setAddress(addressRepository.findByFirstLine(address.getFirstLine()));
        if (client != null && !clientRepository.existsByClientName(client.getClientName())) {
            clientRepository.save(client);
        }
        sampling.setClient(clientRepository.findByClientName(client.getClientName()));
        if (sampling != null && !samplingRepository.existsById(sampling.getId())) {
            samplingRepository.save(sampling);
        }
        sample.setSampling(samplingRepository.findById(sampling.getId()).orElseThrow());

        if (sampleType.equals(sampleType2)) {
            if (!sampleTypeRepository.existsBySampleType(sampleType.getSampleType())) {
                sampleTypeRepository.save(sampleType);
            }
            template.setType(sampleTypeRepository.findBySampleType(sampleType.getSampleType()));
            sample.setSampleType(sampleTypeRepository.findBySampleType(sampleType.getSampleType()));
        }
        if (template != null && !templateRepository.existsByTemplateName(template.getTemplateName())) {
            templateRepository.save(template);
        }
        analysisTemplate.setTemplate(templateRepository.findByTemplateName(template.getTemplateName()));
        if (analysisTemplate != null && !analysisTemplateRepository.existsByDescription(analysisTemplate.getDescription())) {
            analysisTemplateRepository.save(analysisTemplate);
        }
        if (sample != null && !sampleRepository.existsById(sample.getId())) {
            sampleRepository.save(sample);
        }
        analysisOrder.setAnalysisTemplate(analysisTemplateRepository.findByDescription(analysisTemplate.getDescription()));
        analysisOrder.setSample(sampleRepository.findById(sample.getId()).orElseThrow());

        analysisOrder.setOrderDate(LocalDateTime.now());
        return analysisOrderRepository.save(analysisOrder);
    }


}
