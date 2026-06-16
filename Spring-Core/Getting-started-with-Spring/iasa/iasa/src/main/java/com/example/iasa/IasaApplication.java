package com.example.iasa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IasaApplication {

	public static void main(String[] args) {

		SpringApplication.run(IasaApplication.class, args);
	}

    /**
     * Adding CommandLineRunner
     * Adding the Spring Boot Banner Off
     */
    @Bean
    public CommandLineRunner runner() {
        return args -> {
            System.out.println("Application started!");
            System.out.println("Arguments: ");
        };
    }

}
