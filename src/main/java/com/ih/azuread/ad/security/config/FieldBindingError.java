package com.ih.azuread.ad.security.config;

public class FieldBindingError {
	
	private String field;
	private String object;
	private String message;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public FieldBindingError(String object, String field, String message) {
		super();
		this.object = object;
		this.field = field;
		this.message = message;
	}
	
	public FieldBindingError() {
		
	}
}
