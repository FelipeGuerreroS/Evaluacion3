package com.fguerrero.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fguerrero.models.Categoria;
import com.fguerrero.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> obtenerListaCategorias() {
		return categoriaRepository.findAll();
	}
	public List<String> findAllCategoriasNombres(){
		return categoriaRepository.findAllCategoriasNombres();
	}
	public void insertarCategoria(@Valid Categoria categoria) {
		categoriaRepository.save(categoria);
		
	}
	//Buscar categoria
	public Categoria buscarCategoria(Long id) {
		return categoriaRepository.findById(id).get();
	}
	//Eliminar categoria
	public void eliminarCategoria(Long id) {
		categoriaRepository.deleteById(id);
	}
	public void editarCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
		
	}
}
