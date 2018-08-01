package com.shapes.response;

import java.util.ArrayList;

import com.shapes.model.Shape;
import com.shapes.service.validation.Validation;

public class Response {
	private String body;
	private ArrayList<String> errors = new ArrayList<String>();
	public Validation validation = new Validation();
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public void updateBody(String text) {
		this.body +="\n" + text;
	}
	
	public void setErrors(ArrayList<String> errors) {
		this.errors = errors;
	}
	
	public void setError(String error) {
		this.errors.add(error);
	}
	
	public String getBody() {
		return this.body;
	}
	
	public ArrayList<String> getErrors() {
		return this.errors;
	}
	
	public Response getResponse() {
		return this;
	}
	
	public boolean hasErrors() {
		if(errors.isEmpty() || errors == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean hasBody() {
		if(this.body.isEmpty() && this.body != null) {
			return false;
		} else {
			return true;
		}
	}
	
	public void printBody() {
		System.out.println(this.body);
	}
	
	public void printErrors() {
		if(this.errors != null) {
			for(int i = 0; i < this.errors.size(); i++) {
				System.out.println(this.errors.get(i));
			}
		}
	}
	
	public void createResponse(String[] input) {}
	
	public void createResponse(String[] input, ArrayList<Shape> shapes) {}
}
