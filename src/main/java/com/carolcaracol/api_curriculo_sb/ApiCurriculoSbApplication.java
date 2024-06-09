package com.carolcaracol.api_curriculo_sb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiCurriculoSbApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiCurriculoSbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Aplicação rodando na porta 8080");
	}
}
