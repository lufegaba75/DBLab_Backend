package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.analysis.AnalysisOrderDetails;
import com.lufegaba.datalab.model.entities.analysis.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

    List<Measurement> findAllByAnalysisOrderDetail (AnalysisOrderDetails analysisOrderDetail);
}
