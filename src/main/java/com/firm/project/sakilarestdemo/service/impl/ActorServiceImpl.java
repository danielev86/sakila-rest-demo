package com.firm.project.sakilarestdemo.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import com.firm.project.sakilarestdemo.backend.IActorDAO;
import com.firm.project.sakilarestdemo.backend.model.Actor;
import com.firm.project.sakilarestdemo.backend.utility.MyBatisUtility;
import com.firm.project.sakilarestdemo.controller.dto.ActorDTO;
import com.firm.project.sakilarestdemo.converter.ActorDTOConverter;
import com.firm.project.sakilarestdemo.service.IActorService;

@Service
public class ActorServiceImpl implements IActorService {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private IActorDAO actorManager;
	
	@Autowired
	@Qualifier(value="conversionService")
	private ConversionService converter;
	
	@Autowired
	private MyBatisUtility mybatiUtility;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ActorDTO> getAllActor(){
		List<ActorDTO> lstResult = new ArrayList<>();
		
		List<Actor> lstActor = actorManager.findAllActor();
		
		lstResult = (List<ActorDTO>) converter.convert(lstActor
				, TypeDescriptor.collection(Collection.class, TypeDescriptor.valueOf(Actor.class))
				, TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(ActorDTO.class)));
	
		return lstResult;
	}
	
	@SuppressWarnings("unchecked")
	public List<ActorDTO> getAllActorPagination(Integer page, Integer itemPerPage){
		List<Actor> lstActor = null;
		List<ActorDTO> lstResult = new ArrayList<>();
		
		if (page != null && page != 0 && itemPerPage != null && itemPerPage!=0) {
			lstActor = actorManager.findAllActorPagination(mybatiUtility.buildPaginationFilter(page, itemPerPage));
		}else {
			lstActor = new ArrayList<>();
		}
		
		lstResult = (List<ActorDTO>) converter.convert(lstActor
				, TypeDescriptor.collection(Collection.class, TypeDescriptor.valueOf(Actor.class))
				, TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(ActorDTO.class)));
		return lstResult;
	}
	
	@SuppressWarnings("unchecked")
	public List<ActorDTO> getActorWithAllMovieDetail(){
		List<Actor> lstActor = new ArrayList<>();
		List<ActorDTO> lstResult = new ArrayList<>();	
		lstActor = actorManager.findActorWithAllFilm();
		
		if (CollectionUtils.isNotEmpty(lstActor)) {
			lstResult = (List<ActorDTO>) converter.convert(lstActor
					, TypeDescriptor.collection(Collection.class, TypeDescriptor.valueOf(Actor.class))
					, TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(ActorDTO.class)));
		}
		return lstResult;
	}

}
