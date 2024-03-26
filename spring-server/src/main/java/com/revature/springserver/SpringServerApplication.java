package com.revature.springserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {
		"com.revature.springserver.controller",
		"com.revature.springserver.service",
		"com.revature.springserver.repository"},
		exclude = {DataSourceAutoConfiguration.class}
)
public class SpringServerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringServerApplication.class, args);
	}
}
