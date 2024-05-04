package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.exceptions.BadRequestException;
import com.lufegaba.datalab.model.entities.clients.Address;
import com.lufegaba.datalab.model.entities.clients.Client;
import com.lufegaba.datalab.model.entities.clients.Phone;
import com.lufegaba.datalab.model.entities.enumerations.Activity;
import com.lufegaba.datalab.services.ClientService;
import com.lufegaba.datalab.services.TemplateService;
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
    private final TemplateService templateService;

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

    @GetMapping("/{name}")
    public ResponseEntity<Client> getClientByName (@PathVariable String name) {
        return new ResponseEntity<>(clientService.findClientByName(name), HttpStatus.OK);
    }

    @GetMapping("/{activity}/searchActivity")
    public ResponseEntity<List<Client>>getClientsByActivity (@PathVariable String activity) {
        return new ResponseEntity<>(clientService.filterByActivity(activity), HttpStatus.OK);
    }

    @GetMapping("/{name}/searchName")
    public ResponseEntity<List<Client>> getClientsByName (@PathVariable String name) {
        return new ResponseEntity<>(clientService.filterByName(name), HttpStatus.OK);
    }

    @GetMapping("/{town}/searchTown")
    public ResponseEntity<List<Client>> getClientsByTown (@PathVariable String town) {
        return new ResponseEntity<>(clientService.filterByTown(town), HttpStatus.OK);
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

    @PatchMapping("/{id}/address")
    public ResponseEntity<Client> addAddressToClient (@PathVariable Long id, @RequestBody @Valid Address address) {
        return new ResponseEntity<Client>(clientService.addAddressToClient(id, address), HttpStatus.OK);
    }

    @PatchMapping("/{id}/phone")
    public ResponseEntity<Client> addPhoneToClient (@PathVariable Long id, @RequestBody @Valid Phone phone) {
        return new ResponseEntity<Client>(clientService.addPhoneToClient(id, phone), HttpStatus.OK);
    }
}
