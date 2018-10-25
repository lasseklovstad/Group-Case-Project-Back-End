package com.experisproject.experisproject.services;


import com.experisproject.experisproject.models.entities.Owner;
import com.experisproject.experisproject.models.entities.Person;
import com.experisproject.experisproject.models.repositories.OwnerRepository;
import com.experisproject.experisproject.projections.OwnerLimited;
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

	public List<Owner> findAll(){
		List<Owner> result = new ArrayList<>();
		ownerRepository.findAll().forEach(owner -> result.add(owner));
		return result;
	}

	public 	List<OwnerLimited> findAllLimited(){
    	return ownerRepository.findAllLimited();
	}

	public Owner findById(int id){
    	return ownerRepository.findById(id).get();
	}

	public List<Owner> findOwnersIdNameAndTeam(){
    	return ownerRepository.findOwnersIdNameAndTeam();
	}


	public void save(Owner owner){
        ownerRepository.save(owner);
    }
    public void deleteAll(){
        ownerRepository.deleteAll();
    }


}
