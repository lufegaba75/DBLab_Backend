package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.clients.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByClientName (String clientName);
    boolean existsByClientName (String clientName);

}
