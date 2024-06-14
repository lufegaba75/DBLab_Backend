package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.analysis.SampleTemplate;
import com.lufegaba.datalab.model.entities.users.Worker;
import com.lufegaba.datalab.services.SampleTemplateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/sampletemplates")
public class SampleTemplateController {

    private final SampleTemplateService sampleTemplateService;

    @PostMapping
    public ResponseEntity<SampleTemplate> createSampleTemplate (@RequestBody @Valid SampleTemplate sampleTemplate)  {
        return ResponseEntity.ok(sampleTemplateService.createSampleTemplate(sampleTemplate));
    }

    @GetMapping
    public ResponseEntity<List<SampleTemplate>> getAllSampleTemplates () {
        return ResponseEntity.ok(sampleTemplateService.getAllSampleTemplates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SampleTemplate> getSampleTemplateById (@PathVariable Long id) {
        return ResponseEntity.ok(sampleTemplateService.getSampleTemplateById(id));
    }

    @GetMapping("/template/{id}")
    public ResponseEntity<List<SampleTemplate>> getSampleTemplatesByTemplate (@PathVariable Long id) {
        return ResponseEntity.ok(sampleTemplateService.getSampleTemplatesByTemplate(id));
    }

    @GetMapping("/sample/{id}")
    public ResponseEntity<List<SampleTemplate>> getSampleTemplatesBySample (@PathVariable Long id) {
        return ResponseEntity.ok(sampleTemplateService.getSampleTemplateBySample(id));
    }

    @GetMapping("/worker/{id}")
    public ResponseEntity<List<SampleTemplate>> getSampleTemplatesByWorker (@PathVariable Long id) {
        return ResponseEntity.ok(sampleTemplateService.getSampleTemplateByWorker(id));
    }

    @DeleteMapping("/{id}")
    public void deleteSampleTemplateById (@PathVariable Long id) {
       sampleTemplateService.deleteSampleTemplateById(id);
    }
}
