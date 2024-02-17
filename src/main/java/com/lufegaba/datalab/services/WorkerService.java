package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.enumerations.WorkerType;
import com.lufegaba.datalab.model.entities.users.Worker;
import com.lufegaba.datalab.model.repositories.WorkerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class WorkerService {

    private final WorkerRepository workerRepository;

    public Worker createWorker (Worker worker) {
        if (!workerRepository.existsByEmail(worker.getEmail())){
            return workerRepository.save(worker);
        }
            return workerRepository.findByEmail(worker.getEmail());
    }

    public List<Worker> findAllWorkers () {
        return workerRepository.findAll();
    }

    public Worker findWorkerById (Long id) {
        return workerRepository.findById(id).orElseThrow();
    }

    public List<Worker> findAllWorkersByWorkerType (WorkerType workerType) {
        return workerRepository.findAllWorkersByWorkerType(workerType);
    }

    public Worker updateWorkerById (Long id, Worker worker) {
        var workerToUpdate = findWorkerById(id);
        if (worker.getWorkerType()!=null && worker.getWorkerType()!=workerToUpdate.getWorkerType()) {
            workerToUpdate.setWorkerType(worker.getWorkerType());
        }
        if (worker.getEmail()!=null && worker.getEmail()!= workerToUpdate.getEmail()){
            workerToUpdate.setEmail(worker.getEmail());
        }
        return workerToUpdate;
    }

    public void deleteWorkerById (Long id) {
        workerRepository.deleteById(id);
    }
}
