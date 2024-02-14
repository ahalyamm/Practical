package com.practical.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.practical.*"})
@ImportResource("classpath:/beans.xml")
@EnableAutoConfiguration
public class EmployeeApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
