package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.analysis.AnalysisOrder;
import com.lufegaba.datalab.model.entities.analysis.AnalysisOrderDetails;
import com.lufegaba.datalab.model.entities.analysis.AnalysisTemplateTechnique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalysisOrderDetailsRepository extends JpaRepository<AnalysisOrderDetails, Long> {

    List<AnalysisOrderDetails> findAllByAnalysisOrder(AnalysisOrder analysisOrder);
    List<AnalysisOrderDetails> findAllByAnalysis(AnalysisTemplateTechnique analysis);
}
