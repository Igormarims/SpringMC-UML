package com.igormarques.mc;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.igormarques.mc.domain.Categoria;
import com.igormarques.mc.domain.Cidade;
import com.igormarques.mc.domain.Estado;
import com.igormarques.mc.domain.Produto;
import com.igormarques.mc.repositories.CategoriaRepository;
import com.igormarques.mc.repositories.CidadeRepository;
import com.igormarques.mc.repositories.EstadoRepository;
import com.igormarques.mc.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringmcApplication implements CommandLineRunner
 {

	@Autowired
	private	CategoriaRepository repositorio;
		
		@Autowired
		private ProdutoRepository prod;

		@Autowired
		private CidadeRepository cidade;
		
		@Autowired
		private EstadoRepository estado;
	
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
		

		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 =new Cidade(null, "Urbelândia", est1);
		Cidade c2 = new Cidade(null, "São paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
	  
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estado.saveAllAndFlush(Arrays.asList(est1,est2));
		cidade.saveAll(Arrays.asList(c1,c2,c3));
	}

	
}
