package com.fguerrero.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fguerrero.models.Producto;
import com.fguerrero.repositories.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepository;
	
	public List<Producto> obtenerListaProductos(){
		return productoRepository.findAll();
	}

	public List<String> findAllProductosNombres(){
		return productoRepository.findAllProductosNombres();
	}
	
	public void insertarProducto(@Valid Producto producto) {
		productoRepository.save(producto);
		
	}
	public Producto buscarProducto(Long id) {
		return productoRepository.findById(id).get();
	}
	public void eliminarProducto(Long id) {
		productoRepository.deleteById(id);
	}
	//Editar
	public void editarProducto(Producto producto) {
		productoRepository.save(producto);
	}
}
