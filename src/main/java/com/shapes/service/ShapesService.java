package com.shapes.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.shapes.model.Circle;
import com.shapes.model.Coordinate;
import com.shapes.model.Donut;
import com.shapes.model.Shape;
import com.shapes.model.Triangle;
import com.shapes.response.CircleResponse;
import com.shapes.response.CoordinateResponse;
import com.shapes.response.DonutResponse;
import com.shapes.response.Response;
import com.shapes.response.TriangleResponse;

@Service
public class ShapesService {
	public static final String COORDINATES = "coordinates";
	
	public static final String CIRCLE = "circle";
	public static final String TRIANGLE = "triangle";
	public static final String DONUT = "donut";

	public static final String HELP = "help";
	public static final String EXIT = "exit";
	
	public static final int COORDINATE_COUNT = 2;
	
	public ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public Response getResponse(String userInput) {
		if(userInput.trim().isEmpty()) {
			String[] randomString = new String[1];
			return executeCommand(userInput, randomString);
		} else {
			String[] splittedUserInput = getSplittedUserInput(userInput);
			String command = getCommand(splittedUserInput.length, splittedUserInput[0]);
				
			return executeCommand(command, splittedUserInput);
		}
		
	}
	
	private String[] getSplittedUserInput(String userInput) {
		return userInput.split("\\s+");
	}
	
	private boolean isCoordinates(int length) {
		if (length == COORDINATE_COUNT) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private String getCommand(int length, String command) {
		if(isCoordinates(length)) {
			return "coordinates";
		} else {
			return command.toLowerCase();
		}
	}
	
	private String[] insertCoordinateCommand(String[] input) {
		String[] tempInput = new String[3];
		
		tempInput[0] = COORDINATES;
		tempInput[1] = input[0];
		tempInput[2] = input[1];
		
		return tempInput;
	}
	
	private Response executeCommand(String command, String[] input) {
		Response response = null;
		Shape shape = null;
		
		switch(command) {
			case COORDINATES:
				input = insertCoordinateCommand(input);
				response = new CoordinateResponse();
				response.createResponse(input, shapes);
				break;
			case CIRCLE:
				response = new CircleResponse();
				response.createResponse(input);
				if(!response.hasErrors()) {
					Coordinate center = new Coordinate(Double.parseDouble(input[1]), Double.parseDouble(input[2]));
					shape = new Circle(center, Double.parseDouble(input[3]));
					shapes.add(shape);
					response.setBody(shape.getCreationText());
				}
				break;
			case TRIANGLE:
				response = new TriangleResponse();
				response.createResponse(input);
				if(!response.hasErrors()) {
					ArrayList<Coordinate> vertices = new ArrayList<Coordinate>();
					for(int i = 1; i < input.length; i += 2) {
						Coordinate vertice = new Coordinate(Double.parseDouble(input[i]), Double.parseDouble(input[i+1]));
						vertices.add(vertice);
					}
					shape = new Triangle(vertices);
					shapes.add(shape);
					response.setBody(shape.getCreationText());
				}
				break;
			case DONUT:
				shape = new Donut();
				response = new DonutResponse();
				response.createResponse(input);
				if(!response.hasErrors()) {
					double[] radiuses = {Double.parseDouble(input[3]), Double.parseDouble(input[4])};
					Coordinate center = new Coordinate(Double.parseDouble(input[1]), Double.parseDouble(input[2]));
					shape = new Donut(center, radiuses);
					shapes.add(shape);
					response.setBody(shape.getCreationText());
				}
				break;
			case HELP:
				response = new Response();
				response.setBody("help");
				break;
			case EXIT:
				response = new Response();
				response.setBody("status - exited");
				break;
			default:
				response = new Response();
				response.setBody("Bad command");
				response.setError(response.validation.getInvalidCommandError(command));
				break;
		}
		return response;
	}
}
