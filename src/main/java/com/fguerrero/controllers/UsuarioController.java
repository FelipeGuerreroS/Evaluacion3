package com.fguerrero.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fguerrero.models.Usuario;
import com.fguerrero.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	//Registro
	@RequestMapping("/registro")
	public String registroUsuario() {
		return "usuario/registro.jsp";
	}
	//Registrar
	@RequestMapping("/registrar")
	public String registrarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario) {
		usuarioService.insertarUsuario(usuario);
		return "usuario/login.jsp";
	}
	//Login
	@RequestMapping("/login")
	public String loginUsuario() {
		return "index.jsp";
	}
}
