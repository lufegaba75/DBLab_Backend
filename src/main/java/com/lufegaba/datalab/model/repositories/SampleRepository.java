package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.samples.Sample;
import com.lufegaba.datalab.model.entities.samples.Sampling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

    List<Sample> getSamplesBySampling (Sampling sampling);
}
