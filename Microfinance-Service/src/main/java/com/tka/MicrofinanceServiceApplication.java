package com.tka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.tka") // Scan base package explicitly
@EntityScan(basePackages = "com.tka") // If your entities are in a different package
public class MicrofinanceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrofinanceServiceApplication.class, args);
	}

}