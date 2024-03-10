package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.analysis.TemplateTechnique;
import com.lufegaba.datalab.services.TemplateTechniqueService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping ("/templatetechniques")
public class TemplateTechniqueController {

    private final TemplateTechniqueService templateTechniqueService;

    @PostMapping
    public ResponseEntity<TemplateTechnique> createNewTemplateTechnique (@RequestBody @Valid TemplateTechnique templateTechnique) {
        return ResponseEntity.ok(templateTechniqueService.createNewTemplateTechnique(templateTechnique));
    }

    @GetMapping
    public ResponseEntity<List<TemplateTechnique>> getAllTemplateTechiniques () {
        return ResponseEntity.ok(templateTechniqueService.getAllTemplateTechniques());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemplateTechnique> getTemplateTechiniqueById (@PathVariable Long id) {
        return ResponseEntity.ok(templateTechniqueService.findTemplateTechniqueById(id));
    }

    @GetMapping("/templateName={templateName}")
    public ResponseEntity<List<TemplateTechnique>> getAllTechniquesByTemplate (@PathVariable String templateName) {
        return ResponseEntity.ok(templateTechniqueService.findAllByTemplate(templateName));
    }

    @DeleteMapping("/{id}")
    public void deleteTemplateTechinique (@PathVariable Long id) {
        templateTechniqueService.deleteById(id);
    }
}
