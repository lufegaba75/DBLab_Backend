package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.samples.Sample;
import com.lufegaba.datalab.services.SampleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping ("/samples")
public class SampleController {

    private final SampleService sampleService;

    @PostMapping
    public ResponseEntity<Sample> addNewSample (@RequestBody @Valid Sample sample) {
        return ResponseEntity.ok(sampleService.createSample(sample));
    }

    @GetMapping
    public ResponseEntity<List<Sample>> getAllSamples () {
        return ResponseEntity.ok(sampleService.getAllSamples());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sample> getSampleById (@PathVariable Long id) {
        return ResponseEntity.ok(sampleService.getSampleById(id));
    }

    @GetMapping("/sampling={id}")
    public ResponseEntity<List<Sample>> showSamplingSamples (@PathVariable Long id) {
        return ResponseEntity.ok(sampleService.getSamplesBySampling(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSampleById (@PathVariable Long id) {
        sampleService.deleteClientById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
