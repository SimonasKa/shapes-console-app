package com.shapes.model;

import java.util.ArrayList;

public class Triangle extends Shape{
	private int inputCount = 7;
	private ArrayList<Coordinate> vertices;
	
	public Triangle(){}
	
	public Triangle(ArrayList<Coordinate> vertices) {
		this.vertices = vertices;
	}
	
	public void setVertices(ArrayList<Coordinate> vertices) {
		this.vertices = vertices;
	}
	
	public ArrayList<Coordinate> getVertices() {
		return this.vertices;
	}
	
	public String getCreationText() {
		return "triangle with vertice 1 at (" + this.vertices.get(0).getX() + ", " + this.vertices.get(0).getY() + ") and"
				+ " vertice 2 at (" + this.vertices.get(1).getX() + ", " + this.vertices.get(1).getY() +") and"
				+ " vertice 3 at (" + this.vertices.get(2).getX() + ", " + this.vertices.get(2).getY() +")";
	}
	
	public double getS() {
		return vertices.get(0).getX()*(vertices.get(1).getY() - vertices.get(2).getY()) + 
			   vertices.get(1).getX()*(vertices.get(2).getY() - vertices.get(0).getY()) +
			   vertices.get(2).getX()*(vertices.get(0).getY() - vertices.get(1).getY());
	}
	
	public void isCoordinateInArea(Coordinate coordinate) {
		double w1 = 
		( vertices.get(0).getX()*( vertices.get(2).getY()-vertices.get(0).getY() ) + 
		( coordinate.getY() - vertices.get(0).getY() ) * ( vertices.get(2).getX() - vertices.get(0).getX() ) - 
		coordinate.getX() * ( vertices.get(2).getY() - vertices.get(0).getY() ) ) / 
		( ( vertices.get(1).getY() - vertices.get(0).getY() ) * ( vertices.get(2).getX() - vertices.get(0).getX() ) -
		( vertices.get(1).getX() - vertices.get(0).getX() ) * ( vertices.get(2).getY() - vertices.get(0).getY() ) );
		double w2 = 
		( coordinate.getY() - vertices.get(0).getY() - w1 * ( vertices.get(1).getY() - vertices.get(0).getY() ) ) /
		( vertices.get(2).getY() - vertices.get(0).getY() );
		
		if(w1 >= 0 && w2 >= 0 && (w1 + w2 ) <= 1) {
			this.result = true;
		} else {
			this.result = false;
		}
	}

	public int getInputCount() {
		return inputCount;
	}
}
