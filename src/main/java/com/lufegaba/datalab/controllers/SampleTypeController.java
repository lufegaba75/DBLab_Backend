package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.enumerations.SampleGroup;
import com.lufegaba.datalab.model.entities.samples.SampleType;
import com.lufegaba.datalab.services.SampleTypeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/sampletypes")
public class SampleTypeController {

    private final SampleTypeService sampleTypeService;

    @PostMapping
    public ResponseEntity<SampleType> addNewSampleType (@RequestBody @Valid SampleType sampleType) {
        return ResponseEntity.ok(sampleTypeService.createSampleType(sampleType));
    }

    @GetMapping
    public ResponseEntity<List<SampleType>> getAllSampleTypes () {
        return ResponseEntity.ok(sampleTypeService.getAllSampleTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SampleType> getSampleTypeById (@PathVariable Long id) {
        return ResponseEntity.ok(sampleTypeService.getSampleTypeById(id));
    }

    @GetMapping("/group={group}")
    public ResponseEntity<List<SampleType>> getSampleTypesByGroup (@PathVariable String group) {
        return ResponseEntity.ok(sampleTypeService.getSampleTypeByGroup(SampleGroup.valueOf(group)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SampleType> updateSampleType (@PathVariable Long id, @RequestBody @Valid SampleType sampleType) {
        return ResponseEntity.ok(sampleTypeService.updateSampleType(id, sampleType));
    }

    @DeleteMapping("/{id}")
    public void deleteSampleType (@PathVariable Long id) {
        sampleTypeService.deleteSampleType(id);
    }
}
