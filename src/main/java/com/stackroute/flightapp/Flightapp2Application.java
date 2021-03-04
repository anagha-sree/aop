package com.stackroute.flightapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class Flightapp2Application {

	public static void main(String[] args) {
		SpringApplication.run(Flightapp2Application.class, args);
	}

}
