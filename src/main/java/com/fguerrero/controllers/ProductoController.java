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
import com.fguerrero.models.Producto;
import com.fguerrero.services.CategoriaService;
import com.fguerrero.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("")
	public String productos(@ModelAttribute("producto") Producto producto, Model model) {
		model.addAttribute("categoria", new Categoria());
		model.addAttribute("listaProductos", productoService.obtenerListaProductos());
		model.addAttribute("listaCategorias", categoriaService.obtenerListaCategorias());
		productoService.findAllProductosNombres();
		return "producto/producto.jsp";
	}
	
	@RequestMapping("/crear")
	public String crear(@Valid @ModelAttribute("producto") Producto producto) {
		productoService.insertarProducto(producto);
		return "redirect:/producto";
	}
	//Eliminar
	@RequestMapping("/eliminar")
	public String eliminarProducto(@RequestParam("id") Long id) {
		Producto producto = productoService.buscarProducto(id);
		if(producto!=null) {
			productoService.eliminarProducto(id);
		}
		return "redirect:/producto";
	}
	//Editar
	@RequestMapping("/editar")
	public String editar(@RequestParam("id") Long id, Model model,HttpSession session) {
		model.addAttribute("categoria", new Categoria());
		model.addAttribute("listaCategorias", categoriaService.obtenerListaCategorias());
		Producto producto = productoService.buscarProducto(id);
		model.addAttribute("editarProducto", producto);
		session.setAttribute("antiguoProducto", producto);
		
		return "producto/editar.jsp";
	}
	@RequestMapping("/update")
	public String update(@Valid @ModelAttribute("editarProducto") Producto producto, Model model, HttpSession session) {
		Producto antiguoProducto = (Producto)session.getAttribute("antiguoProducto");
		antiguoProducto.setNombre(producto.getNombre());
		antiguoProducto.setMarca(producto.getMarca());
		antiguoProducto.setDescripcion(producto.getDescripcion());
		antiguoProducto.setPrecio(producto.getPrecio());
		antiguoProducto.setCategoria(producto.getCategoria());
		
		productoService.editarProducto(antiguoProducto);
		
		return "redirect:/producto";
	}
}
