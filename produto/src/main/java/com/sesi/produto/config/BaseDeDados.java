package com.sesi.produto.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sesi.produto.model.Pedido;
import com.sesi.produto.model.Produto;
import com.sesi.produto.model.TipoUsuario;
import com.sesi.produto.model.Usuario;
import com.sesi.produto.repository.PedidoRepository;
import com.sesi.produto.repository.ProdutoRepository;
import com.sesi.produto.repository.UsuarioRepository;


@Configuration
public class BaseDeDados {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Bean
	CommandLineRunner executar() {
		return args -> {
			
			Usuario usuario = new Usuario();
			usuario.setNome("Douglas");
			usuario.setTelefone("23423526");
			usuario.setEmail("douglas@gmail.com");
			usuario.setTipoUsuario(TipoUsuario.FUNCIONARIO);
			usuarioRepository.save(usuario);
			
			Produto produto = new Produto();
			produto.setNome("Celular");
			produto.setEstoque(500);
			produto.setPreco(2600);
			produtoRepository.save(produto);
			
			Produto produto1 = new Produto();
			produto1.setNome("Mouse");
			produto1.setEstoque(200);
			produto1.setPreco(90);
			produtoRepository.save(produto1);
			
			Pedido pedido = new Pedido();
			pedido.setProduto(produto1);
			pedido.setQuantidade(3);
			pedido.setData(LocalDate.now().plusDays(5));
			pedido.setValor(500);
			
			
		};
	}
	
}
