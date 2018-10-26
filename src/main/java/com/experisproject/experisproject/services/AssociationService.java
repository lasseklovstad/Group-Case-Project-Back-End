package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.Association;
import com.experisproject.experisproject.models.repositories.AssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationService {
	AssociationRepository associationRepository;

	@Autowired
	AssociationRepository associationRepository(AssociationRepository associationRepository) {
		return this.associationRepository = associationRepository;
	}

	public List<Association> findAssociationsIdNameDescription(){
		return associationRepository.findAssociationsIdNameDescription();
	}

	public void save(Association association) {
		associationRepository.save(association);
	}

	public void deleteAll() {
		associationRepository.deleteAll();
	}
}
