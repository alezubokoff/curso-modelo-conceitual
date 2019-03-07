package com.zubokoff.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zubokoff.cursomc.domain.Pedido;
import com.zubokoff.cursomc.repositories.PedidoRepository;
import com.zubokoff.cursomc.services.exceptios.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado! id: " +
			id + ", Tipo: " + Pedido.class.getName()));
		
	}

}
