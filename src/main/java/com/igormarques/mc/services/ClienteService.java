package com.igormarques.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igormarques.mc.domain.Cliente;
import com.igormarques.mc.repositories.ClienteRepository;
import com.igormarques.mc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	   
	@Autowired
	private ClienteRepository repo;


	public Cliente byId(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException
				("Objeto não encontrado" + id + ",tipo:" 
				+ Cliente.class.getName()));
		}








}
