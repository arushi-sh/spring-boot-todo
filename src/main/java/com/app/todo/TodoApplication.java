package com.app.todo;//package main

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//annotation that marks this class as a main Spring Boot application
public class TodoApplication {

    //func main()
	public static void main(String[] args) {
		//this is where spring boot actually starts
		SpringApplication.run(TodoApplication.class, args);
	}

}
