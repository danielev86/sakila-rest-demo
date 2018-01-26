package com.firm.project.sakilarestdemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.firm.project.sakilarestdemo.backend.IFilmDAO;
import com.firm.project.sakilarestdemo.backend.filter.FilmFilterBean;
import com.firm.project.sakilarestdemo.backend.model.Film;
import com.firm.project.sakilarestdemo.controller.dto.FilmDTO;
import com.firm.project.sakilarestdemo.service.IFilmService;
import com.firm.project.sakilarestdemo.utility.ConverterUtility;
import com.firm.project.sakilarestdemo.utility.GenericUtility;

@Service
public class FilmServiceImpl implements IFilmService{

	private static final long serialVersionUID = 1L;

	@Autowired
	private IFilmDAO filmDAO;
	
	@Autowired
	private GenericUtility genericUtility;

	@Autowired
	@Qualifier(value="conversionService")
	private ConversionService converter;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<FilmDTO> getAllMoviesByCategoryAndActorFilter(String categoryName, String firstName, String lastName){
		List<FilmDTO> lstResult = new ArrayList<>();
		
		FilmFilterBean filterBean = mapFilmFilterBean(categoryName, firstName, lastName);
		List<Film> lstFilm = filmDAO.findMoviesByCategoryAndActor(filterBean);
		
		if (CollectionUtils.isNotEmpty(lstFilm)) {
			lstResult = (List<FilmDTO>) new ConverterUtility<Film>().convertCollection(converter
					, lstFilm
					, List.class
					, FilmDTO.class
					, List.class);
		}
		
		return lstResult;
	}

	private FilmFilterBean mapFilmFilterBean(String categoryName, String firstName, String lastName) {
		FilmFilterBean filterBean = new FilmFilterBean();
		Integer categoryId = StringUtils.isNotEmpty(categoryName) 
				? genericUtility.getCategoryIdByCategoryName(categoryName)
				: null;
		filterBean.setCategoryId(categoryId);
		filterBean.setFirstName(StringUtils.isNotEmpty(firstName) 
				? firstName.toLowerCase() 
				: null);
		filterBean.setLastName(StringUtils.isNotEmpty(lastName)
				? lastName.toLowerCase()
				: null);
		return filterBean;
	}
	
	
	
}
