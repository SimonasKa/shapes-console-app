package com.shapes.service.validation;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class Validation {
	public static final String INVALID_COMMAND_ERROR = " - command does not exist. To see the list of commands use command \"help\".";
	public static final String EMPTY_COMMAND = " No command has been entered";
	public static final String TOO_MANY_ARGUMENTS_ERROR = "Too many arguments has been inputted.";
	public static final String TOO_FEW_ARGUMENTS_ERROR = "Too few arguments has been inputted.";
	public static final String NOT_A_DOUBLE_ERROR = " - is not of type double.";
	
	protected ArrayList<String> errors = new ArrayList<String>();
	
	public String getInvalidCommandError(String command) {
		if(command.isEmpty() || command == null) {
			return EMPTY_COMMAND;
		} else {
			return command + INVALID_COMMAND_ERROR;
		}
	}
	
	public  ArrayList<String> getErrors() {
		return this.errors;
	}
	
	public void checkArgumentLength(int inputted, int required) {
		
		if(inputted > required) {
			this.errors.add(TOO_MANY_ARGUMENTS_ERROR + "You have inputted " + inputted + " instead of " + required);
		} else if(inputted < required) {
			this.errors.add(TOO_FEW_ARGUMENTS_ERROR + "You have inputted " + inputted + " instead of " + required);
		} 
	}
	
	public void isOfTypeDouble(String argument) {
		try{
		    Double.parseDouble(argument);
		} catch( Exception e ){
			this.errors.add(argument + NOT_A_DOUBLE_ERROR);
		}
	}
	
	public boolean hasErrors() {
		if(errors.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	public void validateDoubles(String[] input, int length){
		for(int i = 1; i< length; i++) {
			isOfTypeDouble(input[i]);
		}
	}
	
	public void basicValidation(String[] input, int required) {
		int length = input.length;
		checkArgumentLength(length, required);
		validateDoubles(input, length);
	};
	
}
