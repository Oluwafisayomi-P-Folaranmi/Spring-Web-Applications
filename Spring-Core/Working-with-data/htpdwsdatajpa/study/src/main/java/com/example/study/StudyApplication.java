package com.example.study;

import com.example.study.model.Taco;
import com.example.study.repository.IngredientRepository;
import com.example.study.repository.TacoOrderRepository;
import com.example.study.repository.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudyApplication {

    @Autowired
    IngredientRepository ingredientRepository;
    TacoOrderRepository tacoOrderRepository;
    TacoRepository tacoRepository;
    Taco taco;

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

    @Bean
    public CommandLineRunner initDatabase(TacoRepository tacoRepository) {
        return args -> {
            System.out.println("Application started!");
            System.out.println("Arguments: ");

            Taco taco1 = new Taco();
            taco1.setName("Chicken Taco");

            Taco taco2 = new Taco();
            taco2.setName("Beef Taco");

            tacoRepository.save(taco1);
            tacoRepository.save(taco2);
        };
    }
}
