package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.analysis.AnalysisOrder;
import com.lufegaba.datalab.model.entities.analysis.AnalysisTemplate;
import com.lufegaba.datalab.model.entities.enumerations.SampleState;
import com.lufegaba.datalab.model.repositories.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class AnalysisOrderService {

    private final AnalysisOrderRepository analysisOrderRepository;
    private final SampleRepository sampleRepository;

    public AnalysisOrder createAnalysisOrder (AnalysisOrder analysisOrder) {
        analysisOrder.setOrderDate(LocalDateTime.now());
        return analysisOrderRepository.save(analysisOrder);
    }

    public List<AnalysisOrder> getAllAnalysisOrders() {
        return analysisOrderRepository.findAll();
    }

    public void deleteAnalysisOrderById (Long id) {
        analysisOrderRepository.deleteById(id);
    }

    public AnalysisOrder getAnalysisOrderById (Long id) {
        return analysisOrderRepository.findById(id).orElseThrow();
    }

}
