package edu.ni.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // #1
public class EurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaNamingServerApplication.class, args);

	}

}
