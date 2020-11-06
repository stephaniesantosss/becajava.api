package br.universidade.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversidadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversidadeApplication.class, args);
	}
	
	public void run(String... args) throws Exception {	
		System.out.print("Ola");
	}

}
