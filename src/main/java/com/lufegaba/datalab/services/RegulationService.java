package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.enumerations.RegulationType;
import com.lufegaba.datalab.model.entities.regulations.Regulation;
import com.lufegaba.datalab.model.repositories.RegulationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class RegulationService {

    private final RegulationRepository regulationRepository;

    public Regulation AddRegulation (Regulation regulation) {
        return regulationRepository.save(regulation);
    }

    public List<Regulation> getAllRegulations () {
        return regulationRepository.findAll();
    }

    public Regulation getRegulationById (Long id) {
        return regulationRepository.findById(id).orElseThrow();
    }

    public List<Regulation> getAllRegulationsByType (RegulationType type) {
        return regulationRepository.findRegulationByRegulationType(type);
    }

    public Regulation activateDeactivateRegulation (Long id) {
        var regulationToUpdate = getRegulationById(id);
        regulationToUpdate.setIsActive(!regulationToUpdate.getIsActive());
        return regulationToUpdate;
    }

    public void deleteRegulationById (Long id) {
        regulationRepository.deleteById(id);
    }
}
