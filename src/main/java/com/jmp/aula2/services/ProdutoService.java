package com.jmp.aula2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmp.aula2.dtos.CategoriaDto;
import com.jmp.aula2.entities.Categoria;
import com.jmp.aula2.entities.Produto;
import com.jmp.aula2.entities.ProdutoDto;
import com.jmp.aula2.repositories.CategoriaRepository;
import com.jmp.aula2.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public ProdutoDto inserir(ProdutoDto dto) {
		Produto entidade = new Produto();
		entidade.setNome(dto.getNome());
		entidade.setPreco(dto.getPreco());

		for (CategoriaDto catDto : dto.getCategorias()) {
			Categoria cat = categoriaRepository.getReferenceById(catDto.getId());
			entidade.getCategorias().add(cat); 
		}
		entidade = produtoRepository.save(entidade);
		return new ProdutoDto(entidade);
	}
}
