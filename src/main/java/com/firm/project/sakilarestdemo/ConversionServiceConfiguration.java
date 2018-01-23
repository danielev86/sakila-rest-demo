package com.firm.project.sakilarestdemo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.firm.project.sakilarestdemo.converter.ActorDTOConverter;

@Configuration
public class ConversionServiceConfiguration {
	
	@Bean
	public ConversionService conversionService() {
		ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
		bean.setConverters(getConverter());
		bean.afterPropertiesSet();
		return bean.getObject();
	}
	
	private Set<Converter> getConverter(){
		Set<Converter> converters = new HashSet<>();
		converters.add(new ActorDTOConverter());
		return converters;
	}

}
