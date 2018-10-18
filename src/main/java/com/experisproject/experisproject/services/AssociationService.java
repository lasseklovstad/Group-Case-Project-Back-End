package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.repositories.AssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AssociationService {
    AssociationRepository associationRepository;
    @Autowired
    AssociationRepository associationRepository(AssociationRepository associationRepository){
        return this.associationRepository=associationRepository;
    }
}
