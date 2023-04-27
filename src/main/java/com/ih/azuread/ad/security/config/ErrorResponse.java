package com.ih.azuread.ad.security.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	
	private HttpStatus status;
	private String message = "Your request could not be processed at this time. Please contact Support";
	private List<FieldBindingError> fieldErrors = new ArrayList<>();
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<FieldBindingError> getFieldErrors() {
		return fieldErrors;
	}
	public void setFieldErrors(List<FieldBindingError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
	
	
	public ErrorResponse() {}
	
	public ErrorResponse(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}
	

}
