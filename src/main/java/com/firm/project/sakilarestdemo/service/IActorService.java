package com.firm.project.sakilarestdemo.service;

import java.io.Serializable;
import java.util.List;

import com.firm.project.sakilarestdemo.controller.dto.ActorDTO;

public interface IActorService extends Serializable {

	List<ActorDTO> getAllActor();
	
	List<ActorDTO> getAllActorPagination(Integer page, Integer itemPerPage);
	
	List<ActorDTO> getActorWithAllMovieDetail();

}
