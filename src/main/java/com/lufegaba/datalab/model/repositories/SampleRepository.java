package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.samples.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
}
