package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.clients.Address;
import com.lufegaba.datalab.services.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> createNewAddress (@RequestBody @Valid Address address) {
        return new ResponseEntity<Address>(addressService.createAddress(address), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAddressById (@PathVariable Long id) {
        addressService.deleteAddress(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Address> updateAddress (@PathVariable Long id, @RequestBody @Valid Address address) {
        return new ResponseEntity<Address>(addressService.updateAddress(id, address), HttpStatus.ACCEPTED);
    }
}
