package com.firm.project.sakilarestdemo.controller;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firm.project.sakilarestdemo.controller.dto.ActorDTO;
import com.firm.project.sakilarestdemo.controller.dto.Response;
import com.firm.project.sakilarestdemo.service.IActorService;
import com.firm.project.sakilarestdemo.utility.ResponseEntityBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/actor")
public class ActorController implements Serializable {
	
	private static final Logger logger = Logger.getLogger(ActorController.class);
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IActorService actorService;
	
	@RequestMapping(value="/getAllActor", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<ActorDTO>>> getAllActor(){
		List<ActorDTO> lstActor = null;
		Boolean checkResponse = null;
		
		try {
			lstActor = actorService.getAllActor();
			checkResponse = Boolean.TRUE;
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
			lstActor = new ArrayList<>();
			checkResponse = Boolean.FALSE;
		}
		
		
		ResponseEntityBuilder<List<ActorDTO>> responseEntityBuilder = new ResponseEntityBuilder<>();
		return responseEntityBuilder.buildResponseEntiry(checkResponse, lstActor);	
	}
}
