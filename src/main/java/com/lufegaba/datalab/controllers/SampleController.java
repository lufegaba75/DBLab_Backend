package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.samples.Sample;
import com.lufegaba.datalab.services.SampleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
