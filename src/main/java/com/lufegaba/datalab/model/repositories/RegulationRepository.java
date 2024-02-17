package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.enumerations.RegulationType;
import com.lufegaba.datalab.model.entities.regulations.Regulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegulationRepository extends JpaRepository<Regulation, Long> {

    List<Regulation> findRegulationByRegulationType (RegulationType regulationType);
    boolean existsByShortName (String shortName);
    Regulation findByShortName (String shortName);
}
