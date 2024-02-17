package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.clients.Client;
import com.lufegaba.datalab.model.entities.samples.Sampling;
import com.lufegaba.datalab.model.entities.users.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SamplingRepository extends JpaRepository<Sampling, Long> {

    List<Sampling> findByClient (Client client);
    List<Sampling> findBySamplingDate (LocalDate samplingDate);
    List<Sampling> findBySamplingDateBetween (LocalDate date1, LocalDate date2);
    List<Sampling> findByWorker (Worker worker);
    boolean existsById (Long id);
}
