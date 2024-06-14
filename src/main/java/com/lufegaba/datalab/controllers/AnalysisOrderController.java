package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.analysis.AnalysisOrder;
import com.lufegaba.datalab.services.AnalysisOrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping ("/analysisorders")
public class AnalysisOrderController {

    private final AnalysisOrderService analysisOrderService;

    @PostMapping
    public ResponseEntity<AnalysisOrder> createAnalysisOrder (@RequestBody @Valid AnalysisOrder analysisOrder) {
        return ResponseEntity.ok(analysisOrderService.createAnalysisOrder(analysisOrder));
    }

    @GetMapping("/sample/{id}")
    public ResponseEntity<List<AnalysisOrder>> findAnalysisOrdersBySample (@PathVariable Long id) {
        return ResponseEntity.ok(analysisOrderService.getAnalysisOrdersBySample(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAnalysisOrderById (@PathVariable Long id) {
        analysisOrderService.deleteAnalysisOrderById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
