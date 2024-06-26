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
    public ResponseEntity<List<TemplateTechnique>> getAllTemplateTechniques () {
        return ResponseEntity.ok(templateTechniqueService.getAllTemplateTechniques());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemplateTechnique> getTemplateTechniqueById (@PathVariable Long id) {
        return ResponseEntity.ok(templateTechniqueService.findTemplateTechniqueById(id));
    }

    @GetMapping("/template/{id}")
    public ResponseEntity<List<TemplateTechnique>> getAllTechniquesByTemplate (@PathVariable Long id ){
        return ResponseEntity.ok(templateTechniqueService.findAllByTemplate(id));
    }

    @DeleteMapping("/{id}")
    public void deleteTemplateTechnique (@PathVariable Long id) {
        templateTechniqueService.deleteById(id);
    }
}
