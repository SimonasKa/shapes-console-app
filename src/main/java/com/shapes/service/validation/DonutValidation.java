package com.shapes.service.validation;

public class DonutValidation extends Validation{
	private static final String MATCHING_RADIUSES = "You can't have a donut with matching radiuses";
	
	public void hasMatchingRadiuses(double r1, double r2) {
		if(r1 == r2) {
			errors.add(MATCHING_RADIUSES);
		}
	}
}
