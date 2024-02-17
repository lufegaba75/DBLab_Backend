package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.analysis.Species;
import com.lufegaba.datalab.model.repositories.SpeciesRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class SpeciesService {

    private final SpeciesRepository speciesRepository;

    public Species createSpecies (Species species) {
        return speciesRepository.save(species);
    }

    public List<Species> getAllSpecies () {
        return speciesRepository.findAll();
    }

    public Species getSpeciesById (Long id) { return speciesRepository.findById(id).orElseThrow(); }

    public void deleteSpeciesById (Long id) {
        speciesRepository.deleteById(id);
    }
}
