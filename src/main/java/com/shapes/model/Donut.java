package com.shapes.model;

public class Donut extends Shape{
	private int inputCount = 5;
	private Coordinate center;
	private double[] radiuses;
	
	public Donut(){}
	
	public Donut(Coordinate center, double[] radiuses) {
		this.center = center;
		this.radiuses = radiuses;
	}
	
	public void setCenter(Coordinate center) {
		this.center = center;
	}
	
	public void setRadiuses(double[] radiuses) {
		this.radiuses = radiuses;
	}
	
	public Coordinate getCenter() {
		return this.center;
	}
	
	public double[] getRadiuses() {
		return this.radiuses;
	}
	
	public String getCreationText() {
		return "donut with centre at (" + this.center.getX() + ", " + this.center.getY() + ") "
				+ "and radius 1 is " + this.radiuses[0] + " and radius 2 is " + this.radiuses[1]; 
	}
	
	public double getS() {
		return Math.PI * Math.pow(radiuses[1], 2) - Math.PI * Math.pow(radiuses[0], 2);
	}
	
	public void isCoordinateInArea(Coordinate coordinate) {
		orderRadiuses();
		double coordArea = Math.sqrt((Math.pow(coordinate.getX() - this.center.getX(), 2)) + 
				(Math.pow((coordinate.getY() - this.center.getY()), 2)));
		if(coordArea <= this.radiuses[1] && coordArea >= this.radiuses[0]) {
			this.result = true;
		} else {
			this.result = false;
		}
	}
	
	public int getInputCount() {
		return inputCount;
	}
	
	private void orderRadiuses() {
		if(this.radiuses[0] > this.radiuses[1]) {
			double tempRadius = this.radiuses[1];
			this.radiuses[1] = this.radiuses[0];
			this.radiuses[0] = tempRadius;
		}
	}
}
