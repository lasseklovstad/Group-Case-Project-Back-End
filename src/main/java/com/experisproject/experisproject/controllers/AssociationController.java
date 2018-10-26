package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Association;
import com.experisproject.experisproject.services.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/association")
@CrossOrigin
public class AssociationController {

	@Autowired
	AssociationService associationService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Association> getAssociationsIdNameDescription(){
		return associationService.findAssociationsIdNameDescription();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteOneAssociation(@PathVariable int id){
		associationService.deleteById(id);
	}

	@RequestMapping(value = "/delete/all", method = RequestMethod.DELETE)
	public void deleteAllAssociations(){
		associationService.deleteAll();
	}

}
