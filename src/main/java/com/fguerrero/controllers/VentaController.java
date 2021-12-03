package com.fguerrero.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fguerrero.services.ProductoService;
import com.fguerrero.services.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {
	@Autowired
	VentaService ventaService;
	
	@Autowired
	ProductoService productoService;
	
	/*@RequestMapping("/agregar")
	public String agregarProducto(@RequestParam("id") Long id) {
		Producto producto = productoService.buscarProducto(id);
		if(producto!=null) {
			//ventaService.insertarProductoCarro();
		}
	}*/
}
