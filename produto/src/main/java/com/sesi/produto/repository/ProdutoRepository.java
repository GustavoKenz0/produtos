package com.sesi.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.produto.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
