package com.shapes.model;

public class Circle extends Shape{
	private int inputCount = 4;
	private Coordinate center;
	private double radius;
	
	public Circle(){}
	
	public Circle(Coordinate center, double radius) {
		this.center = center;
		this.radius = radius;
		this.result = false;
	}
	
	public void setCenter(Coordinate center) {
		this.center = center;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public Coordinate getCenter() {
		return this.center;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public String getCreationText() {
		return "circle with centre at (" + this.center.getX() + ", " + this.center.getY() + ") and radius " + this.radius;
	}
	
	public double getS() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public void isCoordinateInArea(Coordinate coordinate) {
		double coordArea = Math.sqrt((Math.pow(coordinate.getX() - this.center.getX(), 2)) + 
				(Math.pow((coordinate.getY() - this.center.getY()), 2)));
		if(coordArea <= this.radius) {
			this.result = true;
		} else {
			this.result = false;
		}
	}
	
	public int getInputCount() {
		return inputCount;
	}
}
