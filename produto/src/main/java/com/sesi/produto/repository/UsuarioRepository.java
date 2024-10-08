package com.sesi.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.produto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
