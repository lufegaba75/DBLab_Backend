package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.clients.Client;
import com.lufegaba.datalab.model.entities.samples.Sampling;
import com.lufegaba.datalab.model.repositories.ClientRepository;
import com.lufegaba.datalab.model.repositories.SamplingRepository;
import com.lufegaba.datalab.model.repositories.WorkerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class SamplingService {

    private final SamplingRepository samplingRepository;
    private final WorkerRepository workerRepository;
    private final ClientRepository clientRepository;

    public Sampling addSampling (Sampling sampling) {

        var client = sampling.getClient();
        var worker = sampling.getWorker();

        if (!clientRepository.existsByClientName(client.getClientName())) {
            clientRepository.save(client);
        } else {
            sampling.setClient(clientRepository.findByClientName(client.getClientName()));
        }
        if (!workerRepository.existsByEmail(worker.getEmail())) {
            workerRepository.save(worker);
        } else {
            sampling.setWorker(workerRepository.findByEmail(worker.getEmail()));
        }
        sampling.setSamplingDate(LocalDate.now());
        sampling.setCreatedAt(LocalDateTime.now());

        return samplingRepository.save(sampling);
    }

    public Sampling addClientToSampling(Long id, Client client) {
        var samplingToUpdate = findSamplingById(id);
        samplingToUpdate.setClient(client);
        return samplingRepository.save(samplingToUpdate);
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
        return samplingRepository.findBySamplingDate(datetime);
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
        return samplingRepository.save(samplingToUpdate);
    }

    public void deleteById (Long id) {
        samplingRepository.deleteById(id);
    }
}
