package com.cg.ums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.cg.ums")
public class SpringBootUserDemoPApplication {

	public static void main(String[] args)//works as initializer
	{
		
		
		SpringApplication.run(SpringBootUserDemoPApplication.class, args);
		System.out.println("welcome to spring boot app");
		
	}

}
