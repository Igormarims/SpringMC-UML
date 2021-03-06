package com.igormarques.mc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igormarques.mc.domain.Pedido;
import com.igormarques.mc.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	
	@Autowired
	private  PedidoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> buscar(@PathVariable Integer id) {
	     return ResponseEntity.ok().body( service.buscar(id)); 
	}


	
}
