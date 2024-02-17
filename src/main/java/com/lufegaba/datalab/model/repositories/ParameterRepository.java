package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.analysis.Parameter;
import com.lufegaba.datalab.model.entities.analysis.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {

List<Parameter> findBySpecies (Species species);

Parameter findByParameterName (String parameterName);

boolean existsByParameterName (String parameterName);

}
