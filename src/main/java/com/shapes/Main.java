package com.shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shapes.response.Response;
import com.shapes.service.ShapesService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner {
	private Scanner scanner;
	Scanner inFile;
	public static final String EXIT = "status - exited";
    @Autowired
    private ShapesService shapesService;

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(Main.class);
        
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);   
    }

    @Override
    public void run(String... args) throws Exception {
    	runShapes();
    }
    
    private String getUserInput() {
    	scanner = new Scanner(System.in);
    	String userInput = scanner.nextLine();
    	
    	return userInput;
    }
    
    public boolean isSettedTextInputEmpty() {
          try {
			inFile = new Scanner(new FileReader("C:\\Users\\Mano\\Documents\\workspace-sts-3.9.5.RELEASE\\shapes-console-app\\src\\test\\resources\\shapes.txt"));
			return false;
		} catch (FileNotFoundException e) {
			return true;
		}
    }
    
    private void runShapes() {
    	Response response = new Response();
    	
    	runTextfileInput(response);
    	runUserInput(response);
    
    	scanner.close();
    }
    
    private void runTextfileInput(Response response) {
    	if(!isSettedTextInputEmpty()) {
    		while(inFile.hasNextLine()) {
    			response = shapesService.getResponse(inFile.nextLine());
        		if(response.hasBody()) {
        			response.printBody();
        		}
        		if(response.hasErrors()) {
        			response.printErrors();
        		}
    		}
    	}
    }
    
    private void runUserInput(Response response) {
    	while (!EXIT.equalsIgnoreCase(response.getBody())) {
    		response = shapesService.getResponse(getUserInput());
    		if(response.hasBody() && response.getBody() != null) {
    			response.printBody();
    		}
    		if(response.hasErrors() && response.getErrors() != null) {
    			response.printErrors();
    		}
    	}
    }
}