package com.sesi.produto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sesi.produto.model.Pedido;
import com.sesi.produto.repository.PedidoRepository;
import com.sesi.produto.repository.ProdutoRepository;
import com.sesi.produto.repository.UsuarioRepository;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/listarPedidos")
	public String listarPedidos(Model modelo) {
		modelo.addAttribute("pedidos", pedidoRepository.findAll());
		return "listarPedidos";
	}
	
	@GetMapping("/novo")
	public String mostrarFormulario(Model modelo) {
		modelo.addAttribute("pedidos", new Pedido());
		modelo.addAttribute("usuario", usuarioRepository.findAll());
		modelo.addAttribute("produtos", produtoRepository.findAll());
		return "formularioPedidos";
	}
	
	@PostMapping("/salvarPedidos")
	public String salvaPedidos(Pedido pedidos) {
		pedidoRepository.save(pedidos);
		return "redirect:/pedidos/listarPedidos";
	}
	
	/* @GetMapping("editarPedidos/{id}")
	public String editarPedidos(@PathVariable("id") int id, Model modelo) {
		Optional<Pedido> pedidosOpt = pedidoRepository.findById(id);
		
		if(pedidosOpt.isPresent()) {
			modelo.addAttribute("tarefa", tarefaOpt.get());
			modelo.addAttribute("tarefa", new Tarefa());
			modelo.addAttribute("usuarios", usuarioRepository.findAll());
			modelo.addAttribute("categorias", categoriaRepository.findAll());
			return "formularioTarefa";
		}else {
			return "redirect:/tarefas/listarTarefas";
		}
	} */
	
	@GetMapping("/removerPedidos/{id}")
	public String removerPedidos(@PathVariable("id") int id) {
		pedidoRepository.deleteById(id);
		return "redirect:/pedidos/listarPedidos";
	}
	
}
