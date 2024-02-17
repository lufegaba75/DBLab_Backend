package com.lufegaba.datalab.model.repositories;

import com.lufegaba.datalab.model.entities.users.DatalabUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<DatalabUser, Long> {

    Optional<DatalabUser> findByUsername (String username);
    Boolean existsByUsername (String username);
}
