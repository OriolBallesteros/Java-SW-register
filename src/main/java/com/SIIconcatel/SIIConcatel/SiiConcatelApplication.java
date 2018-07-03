package com.SIIconcatel.SIIConcatel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SiiConcatelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiiConcatelApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(RebelRepository rebelRepo){

		return (args) -> {

			Rebel solo = new Rebel("Han Solo", "Corellia");
			Rebel luke = new Rebel("Luke Skywalker", "Tatooine");

			rebelRepo.save(solo);
			rebelRepo.save(luke);
		};
	}
}
