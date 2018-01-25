package com.firm.project.sakilarestdemo.converter;

import org.springframework.core.convert.converter.Converter;

import com.firm.project.sakilarestdemo.backend.model.Film;
import com.firm.project.sakilarestdemo.controller.dto.FilmDTO;

public class FilmDTOConverter implements Converter<Film, FilmDTO> {

	@Override
	public FilmDTO convert(Film source) {
		FilmDTO target = new FilmDTO();
		target.setFilmId(source.getFilmId());
		target.setTitle(source.getTitle());
		target.setDescription(source.getDescription());
		target.setRentalDuration(source.getRentalDuration());
		target.setRentalRate(source.getRentalRate());
		target.setReplacementCost(source.getReplacementCost());
		target.setYear(source.getYear());
		target.setLength(source.getLength());
		return target;
	}

}
