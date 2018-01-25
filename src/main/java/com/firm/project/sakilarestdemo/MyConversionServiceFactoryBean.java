package com.firm.project.sakilarestdemo;

import java.util.Set;

import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.ConverterRegistry;

import com.firm.project.sakilarestdemo.converter.ActorDTOConverter;

import org.springframework.core.convert.converter.Converter;




public class MyConversionServiceFactoryBean extends ConversionServiceFactoryBean {
	
	@Override
	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		ConversionService conversionService = getObject();
		ConverterRegistry registry = (ConverterRegistry) conversionService;
		registry.addConverter(getActorDtoConverter(conversionService));
	}
	
	public ActorDTOConverter getActorDtoConverter(ConversionService conversionService){
		ActorDTOConverter converter = new ActorDTOConverter();
		converter.setConversionService(conversionService);
		return converter;
	}

}
