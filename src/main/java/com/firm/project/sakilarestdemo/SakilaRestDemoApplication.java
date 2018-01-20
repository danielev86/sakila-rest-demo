package com.firm.project.sakilarestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class SakilaRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SakilaRestDemoApplication.class, args);
	}
}
