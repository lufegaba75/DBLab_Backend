package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.analysis.AnalysisOrderDetails;
import com.lufegaba.datalab.model.entities.analysis.Measurement;
import com.lufegaba.datalab.model.repositories.AnalysisOrderDetailsRepository;
import com.lufegaba.datalab.model.repositories.AnalysisOrderRepository;
import com.lufegaba.datalab.model.repositories.MeasurementRepository;
import com.lufegaba.datalab.model.repositories.SampleRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final AnalysisOrderDetailsRepository analysisOrderDetailsRepository;
    private final AnalysisOrderRepository analysisOrderRepository;
    private final SampleRepository sampleRepository;

    public List<Measurement> findAllMeasurements() {
        return measurementRepository.findAll();
    }

    public Measurement findMeasurementById (Long id) {
        return measurementRepository.findById(id).orElseThrow();
    }

    public Measurement createNewMeasurement (Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    public void deleteMeasurementById (Long id) {
        measurementRepository.deleteById(id);
    }



}
