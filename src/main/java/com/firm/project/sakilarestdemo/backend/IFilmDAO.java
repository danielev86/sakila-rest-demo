package com.firm.project.sakilarestdemo.backend;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.firm.project.sakilarestdemo.backend.filter.FilmFilterBean;
import com.firm.project.sakilarestdemo.backend.model.Film;

public interface IFilmDAO {

	List<Film> findMoviesByCategoryAndActor(FilmFilterBean filterBean);

}