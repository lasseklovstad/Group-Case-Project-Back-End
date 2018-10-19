package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.Address;
import com.experisproject.experisproject.models.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    @Autowired
    public AddressRepository addressRepository(AddressRepository addressRepository){
        return this.addressRepository=addressRepository;
    }

    public void save(Address address){
        addressRepository.save(address);
    }

    public void deleteAll(){addressRepository.deleteAll();}

}
