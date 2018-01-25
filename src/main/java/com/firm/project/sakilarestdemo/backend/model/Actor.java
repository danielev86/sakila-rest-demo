package com.firm.project.sakilarestdemo.backend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Actor implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long actorId;
	
	private String firstName;
	
	private String lastName;
	
	private Date lastUpdate;
	
	public List<Film> films;

	public Long getActorId() {
		return actorId;
	}

	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
}
