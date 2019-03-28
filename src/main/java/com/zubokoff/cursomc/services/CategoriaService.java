package com.zubokoff.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.zubokoff.cursomc.domain.Categoria;
import com.zubokoff.cursomc.repositories.CategoriaRepository;
import com.zubokoff.cursomc.services.exceptios.DataIntegrityException;
import com.zubokoff.cursomc.services.exceptios.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado! id: " +
			id + ", Tipo: " + Categoria.class.getName()));
		
	}

	public Categoria inserir(Categoria categoria) {
		categoria.setId(null);
		return repo.save(categoria);
	}

	public Categoria update(Categoria categoria) {
		find(categoria.getId());
		return repo.save(categoria);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível remover uma caterogia que possui produtos");
		}
	}

}
