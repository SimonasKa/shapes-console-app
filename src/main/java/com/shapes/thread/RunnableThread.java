package com.shapes.thread;

import com.shapes.model.Coordinate;
import com.shapes.model.Shape;

public class RunnableThread implements Runnable {
	   private Thread t;
	   private Shape shape;
	   private Coordinate coordinate;
	   
	   private String threadName;
	   
	   public RunnableThread( String name, Shape shape, Coordinate coordinate) {
	      this.threadName = name;
	      this.shape = shape;
	      this.coordinate = coordinate;
	   }
	   
	   public synchronized void run() {
	    	 shape.isCoordinateInArea(coordinate);
	    	 if(shape.getResult()) {
	    		 double area = Math.round(shape.getS()*100);
	    		 area = area / 100;
	    		 System.out.println("Point - (" + coordinate.getX() + ", " + coordinate.getY() + ") Belongs to the " 
	    				 +shape.getCreationText() + ", area - " +  area);
	    	 }
	   }
	   
	   public void start () {
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }
}
