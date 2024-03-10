package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.enumerations.RegulationType;
import com.lufegaba.datalab.model.entities.regulations.Regulation;
import com.lufegaba.datalab.services.RegulationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/regulations")
public class RegulationController {

    private final RegulationService regulationService;

    @PostMapping
    public ResponseEntity<Regulation> addNewRegulation (@RequestBody @Valid Regulation regulation) {
        return ResponseEntity.ok(regulationService.AddRegulation(regulation));
    }

    @GetMapping
    public ResponseEntity<List<Regulation>> getAllRegulations () {
        return ResponseEntity.ok(regulationService.getAllRegulations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Regulation> getRegulationById (@PathVariable Long id) {
        return ResponseEntity.ok(regulationService.getRegulationById(id));
    }

    @GetMapping("/type={regulationType}")
    public ResponseEntity<List<Regulation>> getAllRegulationsByType (@PathVariable RegulationType regulationType) {
        return ResponseEntity.ok(regulationService.getAllRegulationsByType(regulationType));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Regulation> activateDeactivateRegulation (@PathVariable Long id) {
        return ResponseEntity.ok(regulationService.activateDeactivateRegulation(id));
    }

    @DeleteMapping("/{id}")
    public void deleteRegulationById (@PathVariable Long id) {
        regulationService.deleteRegulationById(id);
    }
}
