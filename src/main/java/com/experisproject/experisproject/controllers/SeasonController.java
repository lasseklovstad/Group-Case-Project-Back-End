package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Season;
import com.experisproject.experisproject.models.forms.SeasonForm;
import com.experisproject.experisproject.projections.SeasonLimited;
import com.experisproject.experisproject.services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/season")
public class SeasonController {

	@Autowired
	private SeasonService seasonService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public 	List<Season> getSeasonsIdNameDatesDescription(){
		return seasonService.findSeasonsIdNameDatesDescription();
	}


	@RequestMapping(value = "/limitedInfo", method = RequestMethod.GET)
	public List<SeasonLimited> getAllLimited() {
		return seasonService.findAllLimited();
	}



	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createNew(@RequestBody SeasonForm form, HttpServletResponse response) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		dtf = dtf.withLocale(Locale.US);
		try {
			Season season = new Season(form.getName(), LocalDate.parse(form.getStartDate(), dtf), LocalDate.parse(form.getEndDate(), dtf), form.getDescription());
			seasonService.save(season);
			response.setStatus(HttpServletResponse.SC_CREATED);

		} catch (Exception e){
			e.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public void deleteSeasonById(@PathVariable int id, HttpServletResponse response){
		try {
			seasonService.deleteById(id);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception ex) {
			ex.getStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}




}
