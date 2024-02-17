package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.clients.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    boolean existsByFirstLine (String firstLine);
    Address findByFirstLine (String firstLine);
}
