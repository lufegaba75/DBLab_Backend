package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.repositories.MeasurementRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class MeasurementService {

    private final MeasurementRepository measurementRepository;


}
