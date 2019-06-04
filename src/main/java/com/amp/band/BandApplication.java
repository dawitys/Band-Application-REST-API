package com.amp.band;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BandApplication extends SpringBootServletInitializer{
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BandApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BandApplication.class, args);
	}
}
