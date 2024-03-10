package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.analysis.AnalysisTemplateTechnique;
import com.lufegaba.datalab.services.AnalysisTemplateTechniqueService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/analysistemplatetechniques")
public class AnalysisTemplateTechniqueController {

    private final AnalysisTemplateTechniqueService analysisTemplateTechniqueService;

    @PostMapping
    public ResponseEntity<AnalysisTemplateTechnique> createNewATTechnique (
            @RequestBody @Valid AnalysisTemplateTechnique analysisTemplateTechnique
    ) {
        return ResponseEntity.ok(analysisTemplateTechniqueService.createATTechnique(analysisTemplateTechnique));
    }

    @GetMapping
    public ResponseEntity<List<AnalysisTemplateTechnique>> getAllATTechniques () {
        return ResponseEntity.ok(analysisTemplateTechniqueService.getAllAnalysisTemplateTechniques());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalysisTemplateTechnique> getATTechniqueById (@PathVariable Long id) {
        return ResponseEntity.ok(analysisTemplateTechniqueService.findAnalysisTTById(id));
    }

    @GetMapping("/analysistemplate={description}")
    public ResponseEntity<List<AnalysisTemplateTechnique>> getATTechniquesByAnalysisTemplate (@PathVariable String description) {
        return ResponseEntity.ok(analysisTemplateTechniqueService.findAnalysisTTByAnTemplate(description));
    }

    @DeleteMapping("/{id}")
    public void deleteAnalysisTTechnique (@PathVariable Long id) {
        analysisTemplateTechniqueService.deleteAnalysisTemplateTechnique(id);
    }


}
