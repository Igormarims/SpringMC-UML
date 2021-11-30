package com.igormarques.mc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.igormarques.mc.domain.Categoria;
import com.igormarques.mc.repositories.CategoriaRepository;

@SpringBootApplication
public class SpringmcApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository repositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringmcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "informática");
		Categoria cat2 = new Categoria(null, "escritório");
		
		repositorio.saveAll(Arrays.asList(cat1,cat2));
		
		
	}

}
