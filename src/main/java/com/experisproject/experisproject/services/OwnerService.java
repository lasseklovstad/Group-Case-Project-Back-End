package com.experisproject.experisproject.services;


import com.experisproject.experisproject.models.entities.Owner;
import com.experisproject.experisproject.models.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    OwnerRepository ownerRepository;
    @Autowired
    OwnerRepository ownerRepository(OwnerRepository ownerRepository){
        return this.ownerRepository=ownerRepository;
    }

    public void save(Owner owner){
        ownerRepository.save(owner);
    }
}
