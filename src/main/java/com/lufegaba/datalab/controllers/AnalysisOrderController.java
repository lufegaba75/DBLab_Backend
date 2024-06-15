package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.analysis.AnalysisOrder;
import com.lufegaba.datalab.model.entities.analysis.AnalysisOrderDetails;
import com.lufegaba.datalab.services.AnalysisOrderDetailsService;
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
    private final AnalysisOrderDetailsService analysisOrderDetailsService;

    @PostMapping
    public ResponseEntity<AnalysisOrder> createAnalysisOrder (@RequestBody @Valid AnalysisOrder analysisOrder) {
        return ResponseEntity.ok(analysisOrderService.createAnalysisOrder(analysisOrder));
    }

    @GetMapping("/sample/{id}")
    public ResponseEntity<List<AnalysisOrder>> findAnalysisOrdersBySample (@PathVariable Long id) {
        return ResponseEntity.ok(analysisOrderService.getAnalysisOrdersBySample(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalysisOrder> findAnalysisOrderById (@PathVariable Long id) {
        return ResponseEntity.ok(analysisOrderService.getAnalysisOrderById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAnalysisOrderById (@PathVariable Long id) {
        analysisOrderService.deleteAnalysisOrderById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/details/{id}")
    public ResponseEntity<List<AnalysisOrderDetails>> addAllAnalysisToOrder (@PathVariable Long id) {
        return ResponseEntity.ok(analysisOrderDetailsService.addAllAnalysisToOrder(id));
    }

    @PostMapping("/details/order/{id}")
    public ResponseEntity<AnalysisOrderDetails> addAnalysisToOrder (@PathVariable Long id, @RequestBody @Valid AnalysisOrderDetails analysis) {
        var order = analysisOrderService.getAnalysisOrderById(id);
        analysis.setOrder(order);
        return ResponseEntity.ok(analysisOrderDetailsService.createAnalysis(analysis));
    }

    @DeleteMapping("/details/{id}")
    public ResponseEntity<HttpStatus> deleteAnalysisFromOrder (@PathVariable Long id) {
        analysisOrderDetailsService.deleteAnalysisFromOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<AnalysisOrderDetails> getAnalysisOrderDetailsById (@PathVariable Long id) {
        return ResponseEntity.ok(analysisOrderDetailsService.getAnalysisOrderDetailById(id));
    }

    @GetMapping("/details/order/{id}")
    public ResponseEntity<List<AnalysisOrderDetails>> getAllAnalysisFromOrder (@PathVariable Long id) {
        return ResponseEntity.ok(analysisOrderDetailsService.getAllAnalysisFromOrder(id));
    }

}
