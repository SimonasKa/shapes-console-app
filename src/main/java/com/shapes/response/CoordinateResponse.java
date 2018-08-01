package com.shapes.response;

import java.util.ArrayList;

import com.shapes.model.Coordinate;
import com.shapes.model.Shape;
import com.shapes.thread.RunnableThread;

public class CoordinateResponse extends Response {
	private static final int REQUIRED = 3;
	private Response response = getResponse();
	
	public void createResponse(String[] input, ArrayList<Shape> shapes){
		validation.basicValidation(input, REQUIRED);
		
		response.setBody("");
		response.setErrors(validation.getErrors());
		
		if(!validation.hasErrors()) {
			Coordinate coordinate = new Coordinate(Double.parseDouble(input[1]), Double.parseDouble(input[2]));
			int n = shapes.size() / 4;
			if(n >= 1) {
				for(int i = 0; i < n; i+=4) {
					runOneThread(coordinate, input, shapes.get(i), i);
					runOneThread(coordinate, input, shapes.get(i+1), i + 1);
					runOneThread(coordinate, input, shapes.get(i+2), i + 2);
					runOneThread(coordinate, input, shapes.get(i+3), i + 3);
				}
			} 
			if(shapes.size() - n*4 > 0) {
				for(int i = n*4; i < shapes.size(); i++) {
					runOneThread(coordinate, input, shapes.get(i), i);
				}
			}
		}
	}
	
	private void runOneThread(Coordinate coordinate, String[] input, Shape shape, int i) {
		String name = "Thread - ";
		RunnableThread R = new RunnableThread(name + i, shape, coordinate );
		R.start();
	}
}
