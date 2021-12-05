package com.igormarques.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igormarques.mc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
