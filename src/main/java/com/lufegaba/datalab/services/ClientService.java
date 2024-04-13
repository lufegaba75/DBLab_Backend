package com.lufegaba.datalab.services;

import com.lufegaba.datalab.exceptions.BadRequestException;
import com.lufegaba.datalab.exceptions.ResourceNotFoundException;
import com.lufegaba.datalab.model.entities.clients.Address;
import com.lufegaba.datalab.model.entities.clients.Client;
import com.lufegaba.datalab.model.entities.clients.Phone;
import com.lufegaba.datalab.model.repositories.AddressRepository;
import com.lufegaba.datalab.model.repositories.ClientRepository;
import com.lufegaba.datalab.model.repositories.PhoneRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final PhoneRepository phoneRepository;

    public Client createClient (Client client) {
        if (client.getAddress() != null) {
            try {
                addressRepository.save(client.getAddress());
            } catch (Exception e) {
                throw new BadRequestException("Incorrect address");
            }
        }
        if (client.getPhone() != null) {
            try {
                phoneRepository.save(client.getPhone());
            } catch (Exception e) {
                throw new BadRequestException("Incorrect phone");
            }
        }
        return clientRepository.save(client);
    }

    public List<Client> findAllClients () {
        return clientRepository.findAll();
    }

    public Client findClientById (Long id) {
        return clientRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Client with id = " + id + " not found."));
    }

    public void deleteClientById (Long id) {
        var clientToDelete = findClientById(id);
        var addressToDelete = clientToDelete.getAddress();
        var phoneToDelete = clientToDelete.getPhone();
        if (addressToDelete!=null) {
            addressRepository.deleteById(clientToDelete.getAddress().getId());
        }
        if (phoneToDelete!=null) {
            phoneRepository.deleteById(clientToDelete.getPhone().getId());
        }
        if (clientToDelete!=null){
            clientRepository.deleteById(id);
        }
    }

    public void addAddressToClient (Long id, Address address) {
        var addressAdded = addressRepository.save(address);
        var clientToUpdate = findClientById(id);
        if (clientToUpdate.getAddress()!=null) {
            try {
                addressRepository.deleteById(clientToUpdate.getAddress().getId());
                clientToUpdate.setAddress(addressAdded);
            } catch (Exception e) {
                throw new BadRequestException("Address not valid");
            }
        }
        clientToUpdate.setAddress(addressAdded);
    }

    public void addPhoneToClient (Long id, Phone phone) {
        var clientToUpdate = findClientById(id);
        if (clientToUpdate.getPhone()!=null) {
            try {
                phoneRepository.deleteById(clientToUpdate.getPhone().getId());
                clientToUpdate.setPhone(phoneRepository.save(phone));
            } catch (Exception e) {
                throw new BadRequestException("Phone not valid");
            }
        }
        clientRepository.save(clientToUpdate);
    }

    public Client updateClient (Long id, Client client) {
        if (client.getEmail() != null) {
            findClientById(id).setEmail(client.getEmail());
        }
        if (client.getAddress() != null) {
            addAddressToClient(id, client.getAddress());
        }
        if (client.getPhone() != null) {
            addPhoneToClient(id, client.getPhone());
        }
        return findClientById(id);
    }
}
