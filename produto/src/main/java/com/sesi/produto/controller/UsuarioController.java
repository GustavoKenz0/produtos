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

import com.sesi.produto.model.Usuario;
import com.sesi.produto.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/listarUsuario")
	public String listarUsuarios(Model modelo) {
		modelo.addAttribute("usuarios", usuarioRepository.findAll());
		return "listarUsuarios";
	}
	
	@GetMapping("editarUsuario/{id}")
	public String editarUsuario(@PathVariable("id") int id, Model modelo) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
		
		if(usuarioOpt.isPresent()) {
			modelo.addAttribute("usuario", usuarioOpt.get());
			return "formularioUsuario";
		}else {
			return "redirect:/listarUsuario";
		}
	}
	
	@PostMapping("/salvarUsuario")
	public String salvarCategoria(@ModelAttribute Usuario usuario) {
		usuarioRepository.save(usuario);
		return "redirect:/usuarios/listarUsuario";
	}
	
	@GetMapping("/formularioUsuario")
	public String mostrarFormulario(Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		modelo.addAttribute("usuarios", usuarioRepository.findAll());
		return "formularioUsuario";
	}
	
	@GetMapping("/excluirUsuario/{id}")
	public String excluirUsuario(@PathVariable("id") int id) {
		usuarioRepository.deleteById(id);
		return "redirect:/listarUsuario";
	}
	
}
