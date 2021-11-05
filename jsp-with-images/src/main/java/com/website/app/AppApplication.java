package com.website.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.website"})
public class AppApplication extends ServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
}
