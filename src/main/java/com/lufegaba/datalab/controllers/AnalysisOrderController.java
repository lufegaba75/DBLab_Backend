package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.analysis.AnalysisOrder;
import com.lufegaba.datalab.services.AnalysisOrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping ("/analysisorders")
public class AnalysisOrderController {

    private final AnalysisOrderService analysisOrderService;

    @PostMapping
    public ResponseEntity<AnalysisOrder> createAnalysisOrder (@RequestBody @Valid AnalysisOrder analysisOrder) {
        return ResponseEntity.ok(analysisOrderService.createAnalysisOrder(analysisOrder));
    }

}
