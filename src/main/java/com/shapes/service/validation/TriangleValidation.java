package com.shapes.service.validation;

import java.util.ArrayList;

import com.shapes.model.Coordinate;

public class TriangleValidation extends Validation{
	public final static String MATCHING_VERTICES = "You have more than one vertice at point - ";
	
	public void hasMatchingVertices(ArrayList<Coordinate> vertices) {
		for(int i = 0; i < vertices.size(); i++) {
			for(int j = i + 1; j < vertices.size(); j++) {
				if( vertices.get(i).getX() == vertices.get(j).getX() && vertices.get(i).getY() == vertices.get(j).getY() ) {
					errors.add(MATCHING_VERTICES + vertices.get(i).getX() + ", " + vertices.get(i).getY());
				}
			}
		}
	}
}
