package com.igormarques.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igormarques.mc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
