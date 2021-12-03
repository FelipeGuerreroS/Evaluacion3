package com.fguerrero.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fguerrero.models.Usuario;
import com.fguerrero.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	//Listar
	public List<Usuario> obtenerListaUsuarios(){
		return usuarioRepository.findAll();
	}

	public void insertarUsuario(@Valid Usuario usuario) {
		usuarioRepository.save(usuario);
	}
}
