package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.enumerations.SampleGroup;
import com.lufegaba.datalab.model.entities.samples.SampleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleTypeRepository extends JpaRepository<SampleType, Long> {

    List<SampleType> findBySampleGroup (SampleGroup sampleGroup);
    boolean existsBySampleType (String sampleType);
    SampleType findBySampleType (String sampleType);
}
