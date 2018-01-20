package com.firm.project.sakilarestdemo.controller.dto;

import java.io.Serializable;

public class Response<T> implements Serializable {
	
	private Boolean checkResponse;
	
	private T bodyResponse;

	public Boolean getCheckResponse() {
		return checkResponse;
	}

	public void setCheckResponse(Boolean checkResponse) {
		this.checkResponse = checkResponse;
	}

	public T getBodyResponse() {
		return bodyResponse;
	}

	public void setBodyResponse(T bodyResponse) {
		this.bodyResponse = bodyResponse;
	}

}
