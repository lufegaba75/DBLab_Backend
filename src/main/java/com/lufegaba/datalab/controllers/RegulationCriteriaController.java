package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.regulations.RegulationCriteria;
import com.lufegaba.datalab.services.RegulationCriteriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/regulationcriteria")
public class RegulationCriteriaController {

    private final RegulationCriteriaService regulationCriteriaService;

    @PostMapping
    public ResponseEntity<RegulationCriteria> createNewRegulationCriteria (@RequestBody RegulationCriteria regulationCriteria) {
        return ResponseEntity.ok(regulationCriteriaService.createRegulationCriteria(regulationCriteria));
    }

    @GetMapping
    public ResponseEntity<List<RegulationCriteria>> getAllRegulationCriteria () {
        return ResponseEntity.ok(regulationCriteriaService.findAllRegulationCriteria());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<RegulationCriteria> getCriteriaById (@PathVariable Long id) {
        return ResponseEntity.ok(regulationCriteriaService.findRegulationCriteriaById(id));
    }

    @GetMapping ("/regulationtemplate/{id}")
    public ResponseEntity<List<RegulationCriteria>> getRegulationCriteriaByTemplate (@PathVariable Long id) {
        return ResponseEntity.ok(regulationCriteriaService.findByRegulationTemplate(id));
    }

    @DeleteMapping ("/{id}")
    public void deleteRegulationCriteria (@PathVariable Long id) {
        regulationCriteriaService.deleteRegulationCriteria(id);
    }
}
