package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.samples.Sample;
import com.lufegaba.datalab.services.SampleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
