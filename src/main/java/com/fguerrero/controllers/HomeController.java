package com.fguerrero.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fguerrero.models.Usuario;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(@ModelAttribute("usuario") Usuario usuario, Model model) {
		return "usuario/registro.jsp";
	}
}
