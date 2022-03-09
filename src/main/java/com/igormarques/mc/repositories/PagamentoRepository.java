package com.igormarques.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igormarques.mc.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
