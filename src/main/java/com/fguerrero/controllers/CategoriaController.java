package com.fguerrero.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fguerrero.models.Categoria;
import com.fguerrero.services.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("")
	public String categoria(@ModelAttribute("categoria") Categoria categoria, Model model) {
		model.addAttribute("listaCategorias", categoriaService.obtenerListaCategorias());
		categoriaService.findAllCategoriasNombres();
		return "categoria/categoria.jsp";
	}
	@RequestMapping("/registrar")
	public String registrar(@Valid @ModelAttribute("categoria") Categoria categoria) {
		categoriaService.insertarCategoria(categoria);
		return "redirect:/categoria";
	}
	@RequestMapping("/eliminar")
	public String eliminarCategoria(@RequestParam("id") Long id) {
		Categoria categoria = categoriaService.buscarCategoria(id);
		if(categoria!=null) {
			categoriaService.eliminarCategoria(id);
		}
		return "redirect:/categoria";
	}
	//Editar
	@RequestMapping("/editar")
	public String editar(@RequestParam("id") Long id, Model model,HttpSession session) {
		Categoria categoria = categoriaService.buscarCategoria(id);
		model.addAttribute("editarCategoria", categoria);
		session.setAttribute("antiguaCategoria", categoria);
		
		return "categoria/editar.jsp";
	}
	@RequestMapping("/update")
	public String update(@Valid @ModelAttribute("editarCategoria") Categoria categoria, Model model, HttpSession session) {
		Categoria antiguaCategoria = (Categoria)session.getAttribute("antiguaCategoria");
		antiguaCategoria.setNombre(categoria.getNombre());
		antiguaCategoria.setDescripcion(categoria.getDescripcion());
		
		categoriaService.editarCategoria(antiguaCategoria);
		
		return "redirect:/categoria";
	}
}
