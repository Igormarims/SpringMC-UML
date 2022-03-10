package com.igormarques.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igormarques.mc.domain.Categoria;
import com.igormarques.mc.domain.Pedido;
import com.igormarques.mc.repositories.PedidoRepository;
import com.igormarques.mc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService { 
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id){
		Optional<Pedido>  obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException
				("Objeto não encontrado" + id + ",tipo:" 
				+ Pedido.class.getName()));
				}
			

}
