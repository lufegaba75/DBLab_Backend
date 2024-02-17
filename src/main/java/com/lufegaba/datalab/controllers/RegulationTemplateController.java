package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.regulations.Regulation;
import com.lufegaba.datalab.model.entities.regulations.RegulationTemplate;
import com.lufegaba.datalab.services.RegulationTemplateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/regulationtemplates")
public class RegulationTemplateController {

    private final RegulationTemplateService regulationTemplateService;

    @PostMapping
    public ResponseEntity<RegulationTemplate> createNewRegulationTemplate (@RequestBody @Valid RegulationTemplate regulationTemplate) {
        return ResponseEntity.ok(regulationTemplateService.createRegulationTemplate(regulationTemplate));
    }

    @GetMapping
    public ResponseEntity<List<RegulationTemplate>> getAllRegulationTemplates () {
        return ResponseEntity.ok(regulationTemplateService.findAllRegulationTemplates());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<RegulationTemplate> getRegulationTemplateById (@PathVariable Long id) {
        return ResponseEntity.ok(regulationTemplateService.findRegulationByid(id));
    }

    @GetMapping ("/regulation={regulationName}")
    public ResponseEntity<List<RegulationTemplate>> getAllTemplatesByRegulation (@PathVariable String regulationName) {
        return ResponseEntity.ok(regulationTemplateService.findTemplatesByRegulation(regulationName));
    }

    @DeleteMapping("/{id}")
    public void deleteRegulationTemplate (@PathVariable Long id) {
        regulationTemplateService.deleteRegulationById(id);
    }
}
