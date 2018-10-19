package com.experisproject.experisproject.services;


import com.experisproject.experisproject.models.entities.Owner;
import com.experisproject.experisproject.models.entities.Person;
import com.experisproject.experisproject.models.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService {
    OwnerRepository ownerRepository;

    @Autowired
    OwnerRepository ownerRepository(OwnerRepository ownerRepository){
        return this.ownerRepository=ownerRepository;
    }

	public List<Owner> findAll(Person person){
		Iterable<Owner> owners = this.ownerRepository.findByPerson(person);
		List<Owner> result = new ArrayList<>();

		for (Owner owner : owners) {
			result.add(owner);
		}

		return result;
	}

	public Owner findById(int id) {
		return ownerRepository.findById(id).get();
	}

    public void save(Owner owner){
        ownerRepository.save(owner);
    }
    public void deleteAll(){
        ownerRepository.deleteAll();
    }


}
