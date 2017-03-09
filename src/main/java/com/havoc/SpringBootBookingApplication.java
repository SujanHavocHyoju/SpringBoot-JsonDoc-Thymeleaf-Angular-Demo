package com.havoc;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc
public class SpringBootBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookingApplication.class, args);
	}
}
