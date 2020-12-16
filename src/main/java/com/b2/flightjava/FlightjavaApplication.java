package com.b2.flightjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FlightjavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightjavaApplication.class, args);
	}

}
