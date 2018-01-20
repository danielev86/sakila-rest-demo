package com.firm.project.sakilarestdemo.backend;

import java.io.Serializable;
import java.util.List;

import com.firm.project.sakilarestdemo.backend.bo.ActorBO;

public interface IActorDAO extends Serializable {

	List<ActorBO> findAllActor();

}
