package com.firm.project.sakilarestdemo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.firm.project.sakilarestdemo.backend.bo.ActorBO;
import com.firm.project.sakilarestdemo.controller.dto.ActorDTO;

@Component
public class ActorDTOConverter implements Converter<ActorBO, ActorDTO>{

	@Override
	public ActorDTO convert(ActorBO source) {
		ActorDTO target = new ActorDTO();
		target.setActorId(source.getActorId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setLastUpdate(source.getLastUpdate());
		return target;
	}

}
