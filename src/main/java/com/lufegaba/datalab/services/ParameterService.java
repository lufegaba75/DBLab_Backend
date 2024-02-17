package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.analysis.Parameter;
import com.lufegaba.datalab.model.entities.enumerations.ParameterType;
import com.lufegaba.datalab.model.repositories.ParameterRepository;
import com.lufegaba.datalab.model.repositories.SpeciesRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ParameterService {

    private final ParameterRepository parameterRepository;
    private final SpeciesRepository speciesRepository;

    public Parameter createNewParameter (Parameter parameter) {
        var species = parameter.getSpecies();

        if (species != null && !speciesRepository.existsBySpeciesName(species.getSpeciesName())) {
            speciesRepository.save(species);
        } else if (species != null){
            parameter.setSpecies(speciesRepository.findBySpeciesName(species.getSpeciesName()));
        }

        return parameterRepository.save(parameter);
    }

    public List<Parameter> findAllParameters (){
        return parameterRepository.findAll();
    }

    public Parameter findParameterById (Long id) {
        return parameterRepository.findById(id).orElseThrow();
    }

    public List<Parameter> findAllParametersBySpecies (Long id) {
        return parameterRepository.findBySpecies(speciesRepository.findById(id).orElseThrow());
    }

    public void deleteParameterById (Long id) {
        if (findParameterById(id).getParameterType().equals(ParameterType.MICROBIOLÓGICO)) {
            speciesRepository.deleteById(findParameterById(id).getSpecies().getId());
        }
        parameterRepository.deleteById(id);
    }


}
