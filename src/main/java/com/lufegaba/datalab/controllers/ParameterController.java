package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.analysis.Parameter;
import com.lufegaba.datalab.services.ParameterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping ("/parameters")
public class ParameterController {

    private final ParameterService parameterService;

    @PostMapping
    public ResponseEntity<Parameter> createNewParameter (@RequestBody @Valid Parameter parameter) {
        return ResponseEntity.ok(parameterService.createNewParameter(parameter));
    }

    @GetMapping
    public ResponseEntity<List<Parameter>> getAllParameters () {
        return ResponseEntity.ok(parameterService.findAllParameters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parameter> getParameterById (@PathVariable Long id) {
        return ResponseEntity.ok(parameterService.findParameterById(id));
    }

    @GetMapping("/species/{id}")
    public ResponseEntity<List<Parameter>> getParametersBySpecies (@PathVariable Long id) {
        return ResponseEntity.ok(parameterService.findAllParametersBySpecies(id));
    }

    @DeleteMapping("/{id}")
    public void deleteParameter (@PathVariable Long id) {
        parameterService.deleteParameterById(id);
    }
}
