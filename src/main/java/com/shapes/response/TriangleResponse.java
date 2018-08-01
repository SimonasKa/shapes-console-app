package com.shapes.response;

import java.util.ArrayList;

import com.shapes.model.Coordinate;
import com.shapes.service.validation.TriangleValidation;

public class TriangleResponse extends Response{
	private static final int REQUIRED = 7;
	
	public void createResponse(String[] input) {
		Response response = getResponse();
		TriangleValidation triangleValidation = new TriangleValidation();
		triangleValidation.basicValidation(input, REQUIRED);
		if(!triangleValidation.hasErrors()) {
			
			ArrayList<Coordinate> vertices = new ArrayList<Coordinate>();
			for(int i = 1; i < input.length; i += 2) {
				Coordinate vertice = new Coordinate(Double.parseDouble(input[i]), Double.parseDouble(input[i+1]));
				vertices.add(vertice);
			}
			triangleValidation.hasMatchingVertices(vertices);
		}
		
		response.setErrors(triangleValidation.getErrors());
		response.setBody("");
	}
}
