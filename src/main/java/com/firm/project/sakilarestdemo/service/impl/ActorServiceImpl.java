package com.firm.project.sakilarestdemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firm.project.sakilarestdemo.backend.IActorDAO;
import com.firm.project.sakilarestdemo.backend.bo.ActorBO;
import com.firm.project.sakilarestdemo.controller.dto.ActorDTO;
import com.firm.project.sakilarestdemo.converter.ActorDTOConverter;
import com.firm.project.sakilarestdemo.service.IActorService;

@Service
public class ActorServiceImpl implements IActorService {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private IActorDAO actorManager;
	
	@Autowired
	private ActorDTOConverter actorDTOConverter;
	
	@Override
	public List<ActorDTO> getAllActor(){
		List<ActorDTO> lstResult = new ArrayList<>();
		
		List<ActorBO> lstActor = actorManager.findAllActor();
		
		mapActorDTOList(lstActor, lstResult);
	
		return lstResult;
	}
	
	private void mapActorDTOList(List<ActorBO> lstActor, List<ActorDTO> lstResult) {
		
		if (CollectionUtils.isNotEmpty(lstActor)) {
			lstActor.forEach(actor -> lstResult.add(actorDTOConverter.convert(actor)));
		}
	}

}
