package com.igormarques.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igormarques.mc.domain.Categoria;
import com.igormarques.mc.repositories.CategoriaRepository;
import com.igormarques.mc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id){
		Optional<Categoria>  obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException
				("Objeto não encontrado" + id + ",tipo:" 
				+ Categoria.class.getName()));
                }
	
	public Categoria atualizar(Categoria categoria) {
		categoria.setId(null);
		Categoria categorianova = repo.save(categoria);
		return categorianova;
		
	}
	
	

}
