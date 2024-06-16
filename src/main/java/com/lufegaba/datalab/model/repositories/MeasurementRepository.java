package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.analysis.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
}
