package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.samples.Sample;
import com.lufegaba.datalab.model.repositories.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class SampleService {

    private final SampleRepository sampleRepository;
    private final SamplingRepository samplingRepository;
    private final SampleTypeRepository sampleTypeRepository;
    private final WorkerRepository workerRepository;
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final PhoneRepository phoneRepository;

    public Sample createSample (Sample sample) {
        var sampling = sample.getSampling();
            var worker = sampling.getWorker();
            var client = sampling.getClient();
                var address = client.getAddress();
                var phone = client.getPhone();
        var sampleType = sample.getSampleType();

        if (phone != null && !phoneRepository.existsByPhoneNumber(phone.getPhoneNumber())) {
            phoneRepository.save(phone);
        }
        client.setPhone(phoneRepository.findByPhoneNumber(phone.getPhoneNumber()));
        if (address != null && !addressRepository.existsByFirstLine(address.getFirstLine())) {
            addressRepository.save(address);
        }
        if (client != null && !clientRepository.existsByClientName(client.getClientName())) {
            clientRepository.save(client);
        }
        if (worker != null && !workerRepository.existsByEmail(worker.getEmail())) {
            workerRepository.save(worker);
        }
        sampling.setClient(clientRepository.findByClientName(client.getClientName()));
        sampling.setWorker(workerRepository.findByEmail(worker.getEmail()));
        if ( sampling != null && !samplingRepository.existsById(sampling.getId())) {
            samplingRepository.save(sampling);
        }
        sample.setSampling(samplingRepository.findById(sampling.getId()).orElseThrow());
        if ( sampleType != null && sampleTypeRepository.existsBySampleType(sampleType.getSampleType())) {
            sampleTypeRepository.save(sampleType);
        }
        sample.setSampleType(sampleTypeRepository.findBySampleType(sampleType.getSampleType()));

        return sampleRepository.save(sample);
    }
}
