package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Association;
import com.experisproject.experisproject.services.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Association getAssociationById(@PathVariable int id) {
		Association association = associationService.findById(id);
		return association;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createAssociation(@RequestBody Association association, HttpServletResponse response) {
		try {
			//if exists??
			associationService.save(association);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception e) {
			e.getStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void updateAssociation(@RequestBody Association association, HttpServletResponse response) {
		try {
			//if exists??
			associationService.updateAssociation(association);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.getStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}


	/*--------------------------------------------------------------------------------------*
	 *                                DELETE MAPPING/METHODS                                *
	 * -------------------------------------------------------------------------------------*/
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public void deleteAssociationById(@PathVariable int id, HttpServletResponse response){
		try {
			associationService.deleteById(id);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.getStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);

		}
	}

	@RequestMapping(value = "/all/delete", method = RequestMethod.DELETE)
	public void deleteAllAssociations(HttpServletResponse response){
		try {
			associationService.deleteAll();
			response.setStatus(HttpServletResponse.SC_OK);

		}catch (Exception e){
			e.getStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

}
