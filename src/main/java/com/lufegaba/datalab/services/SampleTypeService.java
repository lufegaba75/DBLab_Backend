package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.enumerations.SampleGroup;
import com.lufegaba.datalab.model.entities.samples.SampleType;
import com.lufegaba.datalab.model.repositories.SampleTypeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class SampleTypeService {

    private final SampleTypeRepository sampleTypeRepository;

    public SampleType createSampleType (SampleType sampleType) {
        return sampleTypeRepository.save(sampleType);
    }

    public List<SampleType> getAllSampleTypes () {
        return sampleTypeRepository.findAll();
    }

    public SampleType getSampleTypeById (Long id) {
        return sampleTypeRepository.findById(id).orElseThrow();
    }

    public List<SampleType> getSampleTypeByGroup (SampleGroup group) {
        return sampleTypeRepository.findBySampleGroup(group);
    }

    public void deleteSampleType (Long id) {
        sampleTypeRepository.deleteById(id);
    }


}
