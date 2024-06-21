package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.analysis.AnalysisOrder;
import com.lufegaba.datalab.model.entities.samples.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalysisOrderRepository extends JpaRepository<AnalysisOrder, Long> {
}
