package com.firm.project.sakilarestdemo.utility;

import static org.springframework.core.convert.TypeDescriptor.collection;
import static org.springframework.core.convert.TypeDescriptor.valueOf;

import java.util.List;

import org.springframework.core.convert.ConversionService;

public class ConverterUtility<S> {
	
	public List<?> convertCollection(ConversionService converter
			, List<S> source
			, Class<?> collectionSource
			, Class<?> target
			, Class<?> collectionTarget) {
		return (List<?>) converter.convert(source
				, collection(collectionSource, valueOf(target))
				, collection(collectionTarget, valueOf(target))); 
		
	}

}
