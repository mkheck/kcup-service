package com.thehecklers.kcupservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
class KcupServiceApplication {
	@Bean
	CommandLineRunner demoData(CoffeeRepository repository) {
		return args -> {
			repository.deleteAll();

			Arrays.asList("Espresso Roast", "Kaldi Coffee", "SK Coffee", "Klatch Dark Roast")
					.stream()
					.map(Coffee::new)
					.forEach(repository::save);

			repository.findAll().forEach(System.out::println);
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(KcupServiceApplication.class, args);
	}
}

