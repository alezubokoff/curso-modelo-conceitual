package com.zubokoff.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zubokoff.cursomc.domain.Produto;;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
