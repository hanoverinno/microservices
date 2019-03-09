package edu.ndsi.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAuthorizationServer
@RestController
public class UAAServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UAAServerApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello Nesrin !";
		
	}
}

