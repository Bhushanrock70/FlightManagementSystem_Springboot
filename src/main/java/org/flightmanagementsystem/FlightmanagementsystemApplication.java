package org.flightmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.flightmanagementsystem.model")
@ComponentScan("org.flightmanagementsystem.dao")
@ComponentScan("org.flightmanagementsystem.service")
@ComponentScan("org.flightmanagementsystem.controller")
public class FlightmanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightmanagementsystemApplication.class, args);
	}

}
