package com.igormarques.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igormarques.mc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
