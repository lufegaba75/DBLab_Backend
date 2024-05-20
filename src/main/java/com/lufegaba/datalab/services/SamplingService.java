package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.clients.Client;
import com.lufegaba.datalab.model.entities.samples.Sampling;
import com.lufegaba.datalab.model.entities.users.Worker;
import com.lufegaba.datalab.model.repositories.ClientRepository;
import com.lufegaba.datalab.model.repositories.SamplingRepository;
import com.lufegaba.datalab.model.repositories.WorkerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Service
@AllArgsConstructor
@Transactional
public class SamplingService {

    private final SamplingRepository samplingRepository;
    private final WorkerRepository workerRepository;
    private final ClientRepository clientRepository;

    public Sampling addSampling (Sampling sampling) {
        var today = LocalDate.now();
        var now = LocalDateTime.now();
        sampling.setSampleList(new ArrayList<>());
        sampling.setSamplingDate(today);
        sampling.setCreatedAt(now);
        return this.samplingRepository.save(sampling);
    }

    public Sampling addClientToSampling(Long id, Client client) {
        var samplingToUpdate = findSamplingById(id);
        if (client != null) {
            samplingToUpdate.setClient(client);
        }
        return samplingToUpdate;
    }

    public Sampling addWorkerToSampling(Long id, Worker worker) {
        var samplingToUpdate = findSamplingById(id);
        if (worker != null ) {
            samplingToUpdate.setWorker(worker);
        }
        return samplingToUpdate;
    }

    public List<Sampling> findAllSamplings () {
        return samplingRepository.findAll();
    }

    public Sampling findSamplingById (Long id) {
        return samplingRepository.findById(id).orElseThrow();
    }

    public List<Sampling> getAllClientSamplings (String clientName) {
        return samplingRepository.findByClient(
                clientRepository.findByClientName(clientName)
        );
    }

    public List<Sampling> getSamplingsByDate (LocalDate datetime) {
        var samplings = samplingRepository.findAll();
        samplings.forEach( sampling -> {
            if (!sampling.getSamplingDate().equals(datetime)) samplings.remove(sampling);
        });
        return samplings;
    }

    public List<Sampling> getSamplingsBetweenDates (LocalDate date1, LocalDate date2) {
        return samplingRepository.findBySamplingDateBetween(date1, date2);
    }

    public List<Sampling> getSamplingsByWorker (String email) {
        var worker = workerRepository.findByEmail(email);
        return samplingRepository.findByWorker(worker);
    }

    public Sampling updateSampling (Long id, Sampling sampling) {

        var samplingToUpdate = findSamplingById(id);
        var client = sampling.getClient();
        var worker = sampling.getWorker();
        var objective = sampling.getSamplingObjective();
        var type = sampling.getSamplingType();

        if (client!=null
                && client!=samplingToUpdate.getClient()
                && clientRepository.existsByClientName(client.getClientName())) {
            samplingToUpdate.setClient(client);
        }
        if (worker!=null
                && worker!=samplingToUpdate.getWorker()
                && workerRepository.existsByEmail(worker.getEmail())) {
            samplingToUpdate.setWorker(worker);
        }
        if (objective!=null
                && objective!=samplingToUpdate.getSamplingObjective()) {
            //falta condición de que sea un miembro válido del enum
            samplingToUpdate.setSamplingObjective(objective);
        }
        if (type!=null
                && type!=samplingToUpdate.getSamplingType()) {
            //falta condición de que sea un miembro válido del enum
            samplingToUpdate.setSamplingType(type);
        }
        clientRepository.save(client);
        workerRepository.save(worker);

        return samplingRepository.save(samplingToUpdate);
    }

    public void deleteById (Long id) {
        samplingRepository.deleteById(id);
    }
}
