package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.analysis.Template;
import com.lufegaba.datalab.model.entities.samples.SampleType;
import com.lufegaba.datalab.services.TemplateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/templates")
public class TemplateController {

    private final TemplateService templateService;

    @PostMapping
    public ResponseEntity<Template> createNewTemplate (@RequestBody @Valid Template template) {
        return ResponseEntity.ok(templateService.createTemplate(template));
    }

    @GetMapping
    public ResponseEntity<List<Template>> getAllTemplates () {
        return ResponseEntity.ok(templateService.getAllTemplates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Template> getTemplateById (@PathVariable Long id) {
        return ResponseEntity.ok(templateService.getTemplateById(id));
    }

    @GetMapping("/type/{id}")
    public ResponseEntity<List<Template>> getTemplatesBySampleType (@PathVariable Long id) {
        return ResponseEntity.ok(templateService.getTemplatesBySampleType(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Template> ActivateDeactivateTemplate (@PathVariable Long id) {
        return ResponseEntity.ok(templateService.ActivateDeactivateTemplate(id));
    }

    @DeleteMapping("/{id}")
    public void DeleteTemplate (@PathVariable Long id) {
        templateService.deleteTemplate(id);
    }
}
