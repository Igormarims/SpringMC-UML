package com.igormarques.mc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igormarques.mc.domain.Cliente;
import com.igormarques.mc.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResouce {

	@Autowired
	private ClienteService serv;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> byId(@PathVariable Integer id){
		Cliente obj = serv.byId(id);
		return ResponseEntity.ok().body(obj);
	}







}
