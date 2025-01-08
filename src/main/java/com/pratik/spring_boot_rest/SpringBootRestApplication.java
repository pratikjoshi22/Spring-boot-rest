package com.pratik.spring_boot_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
	}
	//points tbm in content negotiation
	//learning about the jackson library
	//also imported data in both json and xml format using get req in postman
	// with the jackson libray use parameters like where parameters in headers are key and value
	//e.g:- accept and application.xml request
}
