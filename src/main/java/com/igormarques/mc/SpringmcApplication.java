package com.igormarques.mc;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.igormarques.mc.domain.Categoria;
import com.igormarques.mc.domain.Produto;
import com.igormarques.mc.repositories.CategoriaRepository;
import com.igormarques.mc.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringmcApplication implements CommandLineRunner
 {

	@Autowired
	private	CategoriaRepository repositorio;
		
		@Autowired
		private ProdutoRepository prod;

	
	public static void main(String[] args) {
		SpringApplication.run(SpringmcApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "informática");
		Categoria cat2 = new Categoria(null, "escritório");
		
		
		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);
		
		cat1.getPordutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getPordutos().addAll(Arrays.asList(p2));
		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		
		repositorio.saveAll(Arrays.asList(cat1,cat2));
		prod.saveAll(Arrays.asList(p1,p2,p3));
		

		
	}

	
}
