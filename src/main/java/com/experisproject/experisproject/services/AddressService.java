package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.Address;
import com.experisproject.experisproject.models.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    @Autowired
    public AddressRepository addressRepository(AddressRepository addressRepository){
        return this.addressRepository=addressRepository;
    }

    public Address findById(int id){
    	return addressRepository.findById(id).get();
	}


	public List<Address> findAddressesInfo(){

		return this.addressRepository.findAddressesInfo();
	}


	public void updateAddress(Address address){
    	addressRepository.save(address);
	}

    public void save(Address address){
        addressRepository.save(address);
    }

    public void deleteById(int id){
    	addressRepository.findById(id).get();
	}

	public void deleteAll(){addressRepository.deleteAll();}


}
