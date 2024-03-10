package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.analysis.Species;
import com.lufegaba.datalab.services.SpeciesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/species")
public class  SpeciesController {

    public final SpeciesService speciesService;

    @PostMapping
    public ResponseEntity<Species> createNewSpecies (@RequestBody @Valid Species species) {
        return ResponseEntity.ok(speciesService.createSpecies(species));
    }

    @GetMapping
    public ResponseEntity<List<Species>> getAllSpecies () {
        return ResponseEntity.ok(speciesService.getAllSpecies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Species> getSpeciesById (Long id) {
        return ResponseEntity.ok(speciesService.getSpeciesById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteSpecies (Long id) {
        speciesService.deleteSpeciesById(id);
    }

}
