package com.hack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@PropertySource("classpath:application-default.properties")
@EnableAutoConfiguration(exclude={ 
		 org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class 
		 })
@ComponentScan(basePackages="com.hack")
@Controller
@EntityScan(basePackages="com.hack")
public class GeHackApp {
	
	public static void main(String[] args) {
		SpringApplication.run(GeHackApp.class, args);
	}
	
	@RequestMapping(path={"/hack"})
	public String welcome(){
		return "index";
	}
	
}
