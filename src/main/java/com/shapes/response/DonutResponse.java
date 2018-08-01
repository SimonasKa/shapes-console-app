package com.shapes.response;

import com.shapes.service.validation.DonutValidation;

public class DonutResponse extends Response{
	private static final int REQUIRED = 5;
	
	public void createResponse(String[] input) {
		Response response = getResponse();
		DonutValidation donutValidation = new DonutValidation();
		donutValidation.basicValidation(input, REQUIRED);
		
		if(!donutValidation.hasErrors()) {
			donutValidation.hasMatchingRadiuses(Double.parseDouble(input[3]), Double.parseDouble(input[4]));
		}
		
		response.setErrors(donutValidation.getErrors());
		response.setBody("");
	}
}
