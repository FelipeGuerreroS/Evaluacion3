package com.fguerrero.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fguerrero.models.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{
	List<Producto> findAll();
	
	@Query("SELECT p.nombre FROM Producto p")
	List<String> findAllProductosNombres();
}
