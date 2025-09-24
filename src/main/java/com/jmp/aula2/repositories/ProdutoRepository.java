package com.jmp.aula2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmp.aula2.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
