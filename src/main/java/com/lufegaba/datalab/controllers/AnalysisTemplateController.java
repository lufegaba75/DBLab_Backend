package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.analysis.AnalysisTemplate;
import com.lufegaba.datalab.services.AnalysisTemplateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping ("/analysistemplates")
public class AnalysisTemplateController {

    private final AnalysisTemplateService analysisTemplateService;

    @PostMapping
    public ResponseEntity<AnalysisTemplate> createNewAnalysisTemplate (
            @RequestBody @Valid AnalysisTemplate analysisTemplate) {

        return ResponseEntity.ok(analysisTemplateService.createAnalysisTemplate(analysisTemplate));
    }

    @GetMapping
    public ResponseEntity<List<AnalysisTemplate>> getAllAnalysisTemplates () {
        return ResponseEntity.ok(analysisTemplateService.findAllAnalysisTemplates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalysisTemplate> getAnalysisTemplateById (@PathVariable Long id) {
        return ResponseEntity.ok(analysisTemplateService.findAnalysisTemplateById(id));
    }

    @GetMapping("/template={templateName}")
    public ResponseEntity<List<AnalysisTemplate>> getAllByTemplate (@PathVariable String templateName) {
        return ResponseEntity.ok(analysisTemplateService.findAnalysisTemplateByTemplate(templateName));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AnalysisTemplate> activateDeactivateAnalysisTemplate (@PathVariable Long id) {
        return ResponseEntity.ok(analysisTemplateService.activateDeactivateAnalysisTemplate(id));
    }

    @DeleteMapping("/{id}")
    public void deleteAnalysisTemplate (@PathVariable Long id) {
        analysisTemplateService.deleteAnalysisTemplate(id);
    }
}
