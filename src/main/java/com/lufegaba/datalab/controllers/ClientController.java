package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.exceptions.BadRequestException;
import com.lufegaba.datalab.model.entities.clients.Client;
import com.lufegaba.datalab.services.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping(value = "demo")
    public String welcome() {
        return "Welcome from secure endpoint";
    }

    @PostMapping
    public ResponseEntity<Client> createNewClient (@RequestBody @Valid Client client) {
        return new ResponseEntity<Client>(clientService.createClient(client), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients () {
        if (clientService.findAllClients().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(clientService.findAllClients(), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById (@PathVariable Long id) {
        return new ResponseEntity<>(clientService.findClientById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClientById (@PathVariable Long id) {
        clientService.deleteClientById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Client> updateClient (@PathVariable Long id, @RequestBody @Valid Client client) {
        return new ResponseEntity<Client>(clientService.updateClient(id, client), HttpStatus.OK);
    }
}
