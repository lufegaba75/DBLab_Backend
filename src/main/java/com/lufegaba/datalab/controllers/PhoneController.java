package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.clients.Phone;
import com.lufegaba.datalab.services.PhoneService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/phones")
public class PhoneController {

    private final PhoneService phoneService;

    @PostMapping
    public ResponseEntity<Phone> createNewPhone (@RequestBody @Valid Phone phone) {
        return new ResponseEntity<Phone>(phoneService.createPhone(phone), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePhoneById (@PathVariable Long id) {
        phoneService.deletePhone(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Phone> updatePhone (@PathVariable Long id, @RequestBody @Valid Phone phone) {
        return new ResponseEntity<Phone>(phoneService.updatePhone(id, phone), HttpStatus.ACCEPTED);
    }
}
