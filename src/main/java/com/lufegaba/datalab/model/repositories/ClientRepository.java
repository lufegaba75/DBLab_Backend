package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.clients.Client;
import com.lufegaba.datalab.model.entities.enumerations.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByClientName (String clientName);
    List<Client> findByActivity (Activity activity);
    boolean existsByClientName (String clientName);

}
