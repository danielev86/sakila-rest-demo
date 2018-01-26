package com.firm.project.sakilarestdemo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firm.project.sakilarestdemo.controller.dto.FilmDTO;
import com.firm.project.sakilarestdemo.controller.dto.Response;
import com.firm.project.sakilarestdemo.service.IFilmService;
import com.firm.project.sakilarestdemo.utility.ResponseEntityBuilder;

@RestController
@RequestMapping("/film")
public class FilmController implements Serializable {

	private static final Logger logger = Logger.getLogger(FilmController.class);
	
	@Autowired
	private IFilmService filmService;
	
	@RequestMapping(value="/getAllMoviesByCategoryAndActorFilter",params= {"categoryName", "firstName", "lastName"}
	, method=RequestMethod.GET)
	public ResponseEntity<Response<List<FilmDTO>>> getAllMoviesByCategoryAndActorFilter(
				@RequestParam("categoryName") String categoryName
				, @RequestParam("firstName") String firstName
				, @RequestParam("lastName") String lastName
			){
		List<FilmDTO> films = null;
		Boolean checkResponse = null;
		
		try {
			films = filmService.getAllMoviesByCategoryAndActorFilter(categoryName, firstName, lastName);
			checkResponse = Boolean.TRUE;
		}catch(Exception e) {
			logger.error("Cannot retrieve data from table FILM"+e.getMessage(),e);
			films = new ArrayList<>();
			checkResponse = Boolean.FALSE;
		}
		
		ResponseEntityBuilder<List<FilmDTO>> responseBuilder = new ResponseEntityBuilder<>();
		return responseBuilder.buildResponseEntiry(checkResponse, films);
	}
}
