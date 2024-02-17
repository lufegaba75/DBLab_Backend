package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.users.DatalabUser;
import com.lufegaba.datalab.model.entities.users.Role;
import com.lufegaba.datalab.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @PatchMapping("/{id}")
    public ResponseEntity<DatalabUser> changeUserRole (@PathVariable Long id, @RequestParam String roleName) {
        return ResponseEntity.ok(userService.changeUserRole(id, Role.valueOf(roleName)));
    }
}
