package com.sesi.produto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sesi.produto.model.Produto;
import com.sesi.produto.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/listarProduto")
	public String listarProduto(Model modelo) {
		modelo.addAttribute("produtos", produtoRepository.findAll());
		return "listarProduto";
	}
	
	@GetMapping("editarProduto/{id}")
	public String editarProduto(@PathVariable("id") int id, Model modelo) {
		Optional<Produto> produtoOpt = produtoRepository.findById(id);
		
		if(produtoOpt.isPresent()) {
			modelo.addAttribute("produtos", produtoOpt.get());
			return "formularioProduto";
		}else {
			return "redirect:/listarProduto";
		}
	}
	
	@PostMapping("/salvarProduto")
	public String salvarProduto(@ModelAttribute Produto produto) {
		produtoRepository.save(produto);
		return "redirect:/listarProduto";
	}
	
	@GetMapping("/formularioProduto")
	public String formularioProduto(Model modelo) {
		modelo.addAttribute("produtos", new Produto());
		return "formularioProduto";
	}
	
	@GetMapping("/excluirProduto/{id}")
	public String excluirProduto(@PathVariable("id") int id) {
		produtoRepository.deleteById(id);
		return "redirect:/listarProduto";
	}
	
}
