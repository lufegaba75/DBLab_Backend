package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.analysis.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {

    boolean existsBySpeciesName(String speciesName);

   Species findBySpeciesName (String speciesName);
}
