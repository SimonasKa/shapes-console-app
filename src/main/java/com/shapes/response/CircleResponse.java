package com.shapes.response;

import com.shapes.service.validation.Validation;

public class CircleResponse extends Response{
	public static final int REQUIRED = 4;
	
	public void createResponse(String[] input) {
		Response response = getResponse();
		validation = new Validation();
		validation.basicValidation(input, REQUIRED);
		
		response.setErrors(validation.getErrors());
		response.setBody("");
	}
}
