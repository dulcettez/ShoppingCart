package com.example.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingcartApplication.class, args);

	}
	
	@Bean
	CommandLineRunner init(ProductRepository repo) {
	    return args -> {
	        if (repo.count() == 0) {
	            repo.saveAll(List.of(
	                new Product("T-shirt", "Cotton shirt", 25.0, 0.1, 100),
	                new Product("Juice", "Orange juice bottle", 10.0, 0.05, 50),
	                new Product("Dress", "Red evening dress", 75.0, 0.15, 20)
	            ));
	        }
	    };
	}


}
