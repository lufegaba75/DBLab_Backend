package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.results.ResultDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultDetailsRepository extends JpaRepository<ResultDetails, Long> {
}
