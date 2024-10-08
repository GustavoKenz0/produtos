package com.sesi.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.produto.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
