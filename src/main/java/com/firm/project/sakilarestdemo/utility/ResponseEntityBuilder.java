package com.firm.project.sakilarestdemo.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.firm.project.sakilarestdemo.controller.dto.Response;


public class ResponseEntityBuilder<T>{
	
	public ResponseEntity<Response<T>> buildResponseEntiry(Boolean checkResult, T bodyResponse){
		Response<T> response = new Response<>();
		response.setCheckResponse(checkResult);
		response.setBodyResponse(bodyResponse);
		
		return response.getCheckResponse() 
				? new ResponseEntity<Response<T>>(response, HttpStatus.OK)
				: new ResponseEntity<Response<T>>(response, HttpStatus.SERVICE_UNAVAILABLE);
	}

}
