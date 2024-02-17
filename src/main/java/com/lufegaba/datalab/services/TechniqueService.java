package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.analysis.Technique;
import com.lufegaba.datalab.model.repositories.ParameterRepository;
import com.lufegaba.datalab.model.repositories.SpeciesRepository;
import com.lufegaba.datalab.model.repositories.TechniqueRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class TechniqueService {

    private final TechniqueRepository techniqueRepository;
    private final ParameterRepository parameterRepository;
    private final SpeciesRepository speciesRepository;

    public Technique createTechnique (Technique technique) {
       var parameter = technique.getParameter();
       var species = parameter.getSpecies();

       if (species != null && !speciesRepository.existsBySpeciesName(species.getSpeciesName())) {
           speciesRepository.save(species);
       } else if (species != null){
           parameter.setSpecies(speciesRepository.findBySpeciesName(species.getSpeciesName()));
       }
       if (parameter != null && !parameterRepository.existsByParameterName(parameter.getParameterName())) {
           parameterRepository.save(parameter);
       } else if (parameter != null){
           technique.setParameter(parameterRepository.findByParameterName(parameter.getParameterName()));
       }
            return techniqueRepository.save(technique);
    }

    public List<Technique> getAllTechniques () {
        return techniqueRepository.findAll();
    }

    public Technique getTechniqueById (Long id) {
        return techniqueRepository.findById(id).orElseThrow();
    }

    public List<Technique> getTechniquesByParameter (Long id) {
        return techniqueRepository.findByParameter(
                parameterRepository.findById(id).orElseThrow());
    }

    public void deleteTechnique (Long id) {
        techniqueRepository.deleteById(id);
    }

}
