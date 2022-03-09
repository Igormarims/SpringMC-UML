package com.igormarques.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igormarques.mc.domain.Pedido;

public interface PedidoRepository  extends JpaRepository<Pedido, Integer>{

}
