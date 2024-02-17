package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.clients.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

    Phone findByPhoneNumber (String phoneNumber);
    boolean existsByPhoneNumber (String phoneNumber);
}
