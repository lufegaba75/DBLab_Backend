package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.enumerations.SampleState;
import com.lufegaba.datalab.model.entities.samples.Sample;
import com.lufegaba.datalab.model.entities.samples.Sampling;
import com.lufegaba.datalab.model.repositories.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class SampleService {

    private final SampleRepository sampleRepository;
    private final SamplingRepository samplingRepository;
    private final SampleTypeRepository sampleTypeRepository;
    private final WorkerRepository workerRepository;
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final PhoneRepository phoneRepository;

    public Sample createSample (Sample sample) {
        var sampling = sample.getSampling();
        var sampleType = sample.getSampleType();
        if ( sampling != null && !samplingRepository.existsById(sampling.getId())) {
            samplingRepository.save(sampling);
        }
        sample.setSampling(samplingRepository.findById(sampling.getId()).orElseThrow());
        if ( sampleType != null && sampleTypeRepository.existsBySampleType(sampleType.getSampleType())) {
            sampleTypeRepository.save(sampleType);
        }
        sample.setSampleType(sampleTypeRepository.findBySampleType(sampleType.getSampleType()));
        sample.setSampleState(SampleState.RECEIVED);
        return sampleRepository.save(sample);
    }

    public List<Sample> getSamplesBySampling (Long id) {
        var sampling = samplingRepository.findById(id).orElseThrow();
        return sampleRepository.getSamplesBySampling(sampling);
    }

    public List<Sample> getAllSamples () {
        return sampleRepository.findAll();
    }

    public Sample getSampleById (Long id) {
        return sampleRepository.findById(id).orElseThrow();
    }

    public void deleteClientById(Long id) {
        sampleRepository.deleteById(id);
    }
}
