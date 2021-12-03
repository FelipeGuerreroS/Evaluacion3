package com.fguerrero.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fguerrero.models.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
	List<Categoria> findAll();
	
	@Query("SELECT c.nombre FROM Categoria c")
	List<String> findAllCategoriasNombres();
}