package com.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
		System.out.println("Om Ganeshya Namah");
		System.out.println("This is a User service which act as a service registry (i.e.Eureka server)");
		System.out.println("Radhe Radhe");
	}

}
