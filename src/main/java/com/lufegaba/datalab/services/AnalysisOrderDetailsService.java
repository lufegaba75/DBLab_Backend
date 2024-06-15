package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.analysis.AnalysisOrderDetails;
import com.lufegaba.datalab.model.entities.analysis.AnalysisTemplateTechnique;
import com.lufegaba.datalab.model.repositories.AnalysisOrderDetailsRepository;
import com.lufegaba.datalab.model.repositories.AnalysisOrderRepository;
import com.lufegaba.datalab.model.repositories.AnalysisTemplateRepository;
import com.lufegaba.datalab.model.repositories.AnalysisTemplateTechniqueRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class AnalysisOrderDetailsService {

    private final AnalysisOrderDetailsRepository analysisOrderDetailsRepository;
    private final AnalysisOrderRepository analysisOrderRepository;
    private final AnalysisTemplateTechniqueRepository analysisTemplateTechniqueRepository;
    private final AnalysisTemplateRepository analysisTemplateRepository;

    public AnalysisOrderDetails createAnalysis (AnalysisOrderDetails analysis) {
        return analysisOrderDetailsRepository.save(analysis);
    }

    public void deleteAnalysisFromOrder (Long id) {
        analysisOrderDetailsRepository.deleteById(id);
    }

    public List<AnalysisOrderDetails> addAllAnalysisToOrder (Long orderId) {
        var order = analysisOrderRepository.findById(orderId).orElseThrow();
        var template = order.getAnalysisTemplate();
        var techniques = analysisTemplateTechniqueRepository.findByAnalysisTemplate(template);
        List<AnalysisOrderDetails> analysisAdded = new ArrayList<AnalysisOrderDetails>();
        techniques.forEach( technique -> {
            var techniqueToAdd = technique;
            AnalysisOrderDetails analysisToAdd = new AnalysisOrderDetails();
            analysisToAdd.setAnalysis(techniqueToAdd);
            analysisToAdd.setOrder(order);
            analysisAdded.add(this.createAnalysis(analysisToAdd));
        });
        return analysisAdded;
    }

    public AnalysisOrderDetails getAnalysisOrderDetailById (Long id) {
        return analysisOrderDetailsRepository.findById(id).orElseThrow();
    }

    public List<AnalysisOrderDetails> findAllAnalysisOrderDetails() {
        return analysisOrderDetailsRepository.findAll();
    }

    public List<AnalysisOrderDetails> getAllAnalysisFromOrder (Long id) {
        var order = analysisOrderRepository.findById(id).orElseThrow();
        return analysisOrderDetailsRepository.findAllByOrder(order);
    }

}
