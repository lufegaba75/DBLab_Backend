package com.lufegaba.datalab.services;

import com.lufegaba.datalab.model.entities.users.DatalabUser;
import com.lufegaba.datalab.model.entities.users.Role;
import com.lufegaba.datalab.model.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public DatalabUser changeUserRole (Long id, Role role) {
        var userToChange = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (userToChange.getRole()!=role) {
            userToChange.setRole(role);
        }
        userRepository.save(userToChange);
        return userToChange;
    }
}
