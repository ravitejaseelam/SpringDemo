package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	// todo - Create exceptions (controlleradvice)
	//				UserNotFoundException(id) -update/get (404)
	//				UserInvalidDataException("description") - description empty/null (400)
	//				- ErrorResponse {errorClass = "UserNotFoundException",message = "Could not find user with id 1"}
	//				- ErrorResponse {errorClass = "UserInvalidDataException",message = "Could get value for description"}
	//				- ErrorResponse {errorClass = "Exception",message = "e.getMessage()"}



}
