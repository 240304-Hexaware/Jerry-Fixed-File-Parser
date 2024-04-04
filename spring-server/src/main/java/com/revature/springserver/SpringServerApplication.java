package com.revature.springserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = {
		"com.revature.springserver.controller",
		"com.revature.springserver.service",
		"com.revature.springserver.repository"},
		exclude = {DataSourceAutoConfiguration.class}
)
public class SpringServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServerApplication.class, args);
	}
}
