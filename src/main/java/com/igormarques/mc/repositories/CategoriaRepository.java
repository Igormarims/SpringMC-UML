package com.igormarques.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igormarques.mc.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
