package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.results.SampleResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleResultRepository extends JpaRepository<SampleResult, Long> {
}
