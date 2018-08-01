package com.shapes.model;

public class Shape {
	protected boolean result;
	
	public Shape(){};
	
	public String getCreationText() {
		return "default method text";
	}
	
	public void isCoordinateInArea (Coordinate coordinate) {}
	
	public double getS() {
		return 0;
	}
	
	public boolean getResult() {
		return result;
	}
}
