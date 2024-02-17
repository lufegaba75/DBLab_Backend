package com.lufegaba.datalab.services;

import com.lufegaba.datalab.exceptions.ResourceNotFoundException;
import com.lufegaba.datalab.model.entities.clients.Phone;
import com.lufegaba.datalab.model.repositories.PhoneRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class PhoneService {

    private final PhoneRepository phoneRepository;

    public Phone findPhoneById (Long id) {
        return phoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The phone with id= " + id + " does not exist."));
    }

    public Phone createPhone (Phone phone) {
            return phoneRepository.save(phone);
    }

    public void deletePhone (Long id) {
        phoneRepository.deleteById(id);
    }

    public Phone updatePhone (Long id, Phone phone) {
        var phoneToUpdate = findPhoneById(id);
        if (phone.getInternationalCode()!=null) phoneToUpdate.setInternationalCode(phone.getInternationalCode());
        if (phone.getPhoneNumber()!=null) phoneToUpdate.setPhoneNumber(phone.getPhoneNumber());
        if (phone.getActiveNumber()!=null) phoneToUpdate.setActiveNumber(phone.getActiveNumber());

        return phoneRepository.save(phoneToUpdate);
    }
}
