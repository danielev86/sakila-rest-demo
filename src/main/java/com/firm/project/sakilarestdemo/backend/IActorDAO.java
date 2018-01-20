package com.firm.project.sakilarestdemo.backend;

import java.io.Serializable;
import java.util.List;

import com.firm.project.sakilarestdemo.backend.bo.ActorBO;
import com.firm.project.sakilarestdemo.backend.filter.PaginatorFilterBean;

public interface IActorDAO extends Serializable {

	List<ActorBO> findAllActor();
	
	List<ActorBO> findAllActorPagination(PaginatorFilterBean filter);

}
