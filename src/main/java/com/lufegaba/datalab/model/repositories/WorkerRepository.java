package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.enumerations.WorkerType;
import com.lufegaba.datalab.model.entities.users.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    List<Worker> findAllWorkersByWorkerType (WorkerType workerType);
    boolean existsByEmail (String email);
    Worker findByEmail (String email);
}
