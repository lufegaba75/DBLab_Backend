package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.analysis.Measurement;
import com.lufegaba.datalab.services.MeasurementService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;

    @PostMapping
    public ResponseEntity<Measurement> createMeasurement (@RequestBody @Valid Measurement measurement) {
        return ResponseEntity.ok(measurementService.createNewMeasurement(measurement));
    }

    @GetMapping
    public ResponseEntity<List<Measurement>> getAllMeasurements () {
        return ResponseEntity.ok(measurementService.findAllMeasurements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Measurement> findMeasurementById (@PathVariable Long id) {
        return ResponseEntity.ok(measurementService.findMeasurementById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMeasurementById (@PathVariable Long id) {
        measurementService.deleteMeasurementById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
