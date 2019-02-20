package com.zubokoff.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zubokoff.cursomc.domain.Categoria;
import com.zubokoff.cursomc.repositories.CategoriaRepository;
import com.zubokoff.cursomc.services.exceptios.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
//		return obj.orElse(null);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado! id: " +
			id + ", Tipo: " + Categoria.class.getName()));
		
	}

}
