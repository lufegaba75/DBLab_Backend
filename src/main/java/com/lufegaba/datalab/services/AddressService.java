package com.lufegaba.datalab.services;

import com.lufegaba.datalab.exceptions.ResourceNotFoundException;
import com.lufegaba.datalab.model.entities.clients.Address;
import com.lufegaba.datalab.model.repositories.AddressRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class AddressService {

    private final AddressRepository addressRepository;

    public Address findAddressById (Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The address with id= " + id + " doesn't exist."));
    }

    public Address createAddress (Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress (Long id) {
        addressRepository.deleteById(id);
    }

    public Address updateAddress (Long id, Address address) {
        var addressToUpdate = findAddressById(id);
        if (address.getWayType()!=null) addressToUpdate.setWayType(address.getWayType());
        if (address.getFirstLine()!=null) addressToUpdate.setFirstLine(address.getFirstLine());
        if (address.getPostalCode()!=null) addressToUpdate.setPostalCode(address.getPostalCode());
        if (address.getTown()!=null) addressToUpdate.setTown(address.getTown());
        if (address.getProvince()!=null) addressToUpdate.setProvince(address.getProvince());

        return addressRepository.save(addressToUpdate);
    }
}
