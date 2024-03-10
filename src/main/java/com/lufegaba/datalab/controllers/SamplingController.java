package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.samples.Sampling;
import com.lufegaba.datalab.services.SamplingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/samplings")
public class SamplingController {

    private final SamplingService samplingService;

    @PostMapping
    public ResponseEntity<Sampling> createNewSampling (@RequestBody @Valid Sampling sampling) {
        return ResponseEntity.ok(samplingService.addSampling(sampling));
    }

    //añadir page & sorting
    @GetMapping
    public ResponseEntity<List<Sampling>> getAllSamplings () {
        return ResponseEntity.ok(samplingService.findAllSamplings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sampling> getSamplingById (@PathVariable Long id) {
        return ResponseEntity.ok(samplingService.findSamplingById(id));
    }

    @GetMapping("/client/{name}")
    public ResponseEntity<List<Sampling>> getAllSamplingsByClient (@PathVariable String name) {
        return ResponseEntity.ok(samplingService.getAllClientSamplings(name));
    }

    @GetMapping("/date")
    public ResponseEntity<List<Sampling>> getAllSamplingsByDate () {
        return ResponseEntity.ok(samplingService.getSamplingsByDate(LocalDate.now()));
    }

    //ojo formato de fechas.
    @GetMapping("/date/between={date1}&{date2}")
    public ResponseEntity<List<Sampling>> getSamplingsBetweenDates (
            @PathVariable LocalDate date1,
            @PathVariable LocalDate date2) {
        return ResponseEntity.ok(samplingService.getSamplingsBetweenDates(date1, date2));
    }

    @GetMapping("/worker/{email}")
    public ResponseEntity<List<Sampling>> getSamplingsByWorker (@PathVariable String email) {
        return ResponseEntity.ok(samplingService.getSamplingsByWorker(email));
    }

    @DeleteMapping("/{id}")
    public void deleteSampling (@PathVariable Long id) {
        samplingService.deleteById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Sampling> updateSamplingData (
            @PathVariable Long id,
            @RequestBody @Valid Sampling sampling) {
        return  ResponseEntity.ok(samplingService.updateSampling(id, sampling));
    }

}
