package com.firm.project.sakilarestdemo.backend;

import java.io.Serializable;
import java.util.List;

import com.firm.project.sakilarestdemo.backend.filter.PaginatorFilterBean;
import com.firm.project.sakilarestdemo.backend.model.Actor;

public interface IActorDAO extends Serializable {

	List<Actor> findAllActor();
	
	List<Actor> findAllActorPagination(PaginatorFilterBean filter);
	
	List<Actor> findActorWithAllFilm();

}
