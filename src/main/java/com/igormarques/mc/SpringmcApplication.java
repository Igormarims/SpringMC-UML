package com.igormarques.mc;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.igormarques.mc.domain.Categoria;
import com.igormarques.mc.domain.Cidade;
import com.igormarques.mc.domain.Cliente;
import com.igormarques.mc.domain.Endereco;
import com.igormarques.mc.domain.Estado;
import com.igormarques.mc.domain.Pagamento;
import com.igormarques.mc.domain.PagamentoComBoleto;
import com.igormarques.mc.domain.PagamentoComCartao;
import com.igormarques.mc.domain.Pedido;
import com.igormarques.mc.domain.Produto;
import com.igormarques.mc.domain.enums.EstadoPagamento;
import com.igormarques.mc.domain.enums.TipoCliente;
import com.igormarques.mc.repositories.CategoriaRepository;
import com.igormarques.mc.repositories.CidadeRepository;
import com.igormarques.mc.repositories.ClienteRepository;
import com.igormarques.mc.repositories.EnderecoRepository;
import com.igormarques.mc.repositories.EstadoRepository;
import com.igormarques.mc.repositories.PagamentoRepository;
import com.igormarques.mc.repositories.PedidoRepository;
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
		
		@Autowired
		private ClienteRepository cliente;
		
		@Autowired
		private EnderecoRepository endereco;
		
		@Autowired
		private PedidoRepository pedidoRepository;
		
		@Autowired
		private PagamentoRepository pagamentoRepository;
	
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
	
	    
		Cliente cli1 = new Cliente(null, "Maria silva", "maria@gmail.com","36378912377" ,TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		
		Endereco e1 = new Endereco(null, "rua flores", "300", "Apto 303", "jardim", "38220834", cli1, c1);
	    Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
	
	    cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
	    
	    cliente.saveAll(Arrays.asList(cli1));
	    
	    endereco.saveAll(Arrays.asList(e1,e2));
	
	   
	    
	       Pedido ped1 = new Pedido(null ,null,e1,cli1);
	       Pedido ped2 = new Pedido(null,null , e2, cli1);
	
	       Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
	       ped1.setPagamento(pagto1);
	       
	       Pagamento pagto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,null , ped2, null);
	       ped2.setPagamento(pagto2);
	
	       cli1.getPedido().addAll(Arrays.asList(ped1,ped2));      
	
	       pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
	
	       pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
	
	 
	}
 }


