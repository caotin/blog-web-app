package com.blog.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class WebAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}
}
