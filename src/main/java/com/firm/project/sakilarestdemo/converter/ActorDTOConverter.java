package com.firm.project.sakilarestdemo.converter;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.firm.project.sakilarestdemo.backend.model.Actor;
import com.firm.project.sakilarestdemo.backend.model.Film;
import com.firm.project.sakilarestdemo.controller.dto.ActorDTO;
import com.firm.project.sakilarestdemo.controller.dto.FilmDTO;

import java.util.Collection;
import java.util.List;

@Component
public class ActorDTOConverter implements Converter<Actor, ActorDTO>{

	@Autowired
	@Qualifier("conversionService")
	private ConversionService conversionService;
	
	@Override
	public ActorDTO convert(Actor source) {
		ActorDTO target = new ActorDTO();
		target.setActorId(source.getActorId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setLastUpdate(source.getLastUpdate());
		if (CollectionUtils.isNotEmpty(source.getFilms())) {
			List<FilmDTO> lstFilm = (List<FilmDTO>) conversionService.convert(source.getFilms()
					, TypeDescriptor.collection(Collection.class, TypeDescriptor.valueOf(Film.class))
					, TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FilmDTO.class)));
			target.setFilms(lstFilm);
		}
		return target;
	}

	public ConversionService getConversionService() {
		return conversionService;
	}

	public void setConversionService(ConversionService conversionService) {
		this.conversionService = conversionService;
	}
}
