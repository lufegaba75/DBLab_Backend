package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.analysis.Technique;
import com.lufegaba.datalab.services.TechniqueService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/techniques")
public class TechniqueController {

    private final TechniqueService techniqueService;

    @PostMapping
    public ResponseEntity<Technique> createNewTechnique (@RequestBody Technique technique) {
        return ResponseEntity.ok(techniqueService.createTechnique(technique));
    }

    @GetMapping
    public ResponseEntity<List<Technique>> getAllTechniques () {
        return ResponseEntity.ok(techniqueService.getAllTechniques());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technique> getTechniqueById (@PathVariable Long id) {
        return ResponseEntity.ok(techniqueService.getTechniqueById(id));
    }

    @GetMapping("/parameter/{id}")
    public ResponseEntity<List<Technique>> getTechniquesByParameter (@PathVariable Long id) {
        return ResponseEntity.ok(techniqueService.getTechniquesByParameter(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Technique> updateTechnique (@PathVariable Long id, @RequestBody @Valid Technique technique) {
        return ResponseEntity.ok(techniqueService.updateTechnique(id, technique));
    }

    @DeleteMapping("/{id}")
    public void deleteTechniqueById (@PathVariable Long id) {
        techniqueService.deleteTechnique(id);
    }
}

