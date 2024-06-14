package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.analysis.AnalysisOrder;
import com.lufegaba.datalab.model.entities.analysis.AnalysisTemplate;
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
    private final AnalysisTemplateRepository analysisTemplateRepository;
    private final TemplateRepository templateRepository;
    private final SampleTypeRepository sampleTypeRepository;
    private final SamplingRepository samplingRepository;
    private final ClientRepository clientRepository;
    private final PhoneRepository phoneRepository;
    private final AddressRepository addressRepository;
    private final WorkerRepository workerRepository;

    public AnalysisOrder createAnalysisOrder (AnalysisOrder analysisOrder) {

        analysisOrder.setOrderDate(LocalDateTime.now());
        return analysisOrderRepository.save(analysisOrder);
    }

    public List<AnalysisOrder> getAnalysisOrdersBySample (Long id) {
        var sample = sampleRepository.findById(id).orElseThrow();
        return analysisOrderRepository.findAnalysisOrderBySample(sample);
    }

    public void deleteAnalysisOrderById (Long id) {
        analysisOrderRepository.deleteById(id);
    }


}
