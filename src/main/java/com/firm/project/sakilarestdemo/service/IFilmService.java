package com.firm.project.sakilarestdemo.service;

import java.io.Serializable;
import java.util.List;

import com.firm.project.sakilarestdemo.controller.dto.FilmDTO;

public interface IFilmService extends Serializable {

	List<FilmDTO> getAllMoviesByCategoryAndActorFilter(String categoryName, String firstName, String lastName);

}
