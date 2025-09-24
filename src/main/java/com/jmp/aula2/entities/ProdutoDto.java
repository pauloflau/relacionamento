package com.jmp.aula2.entities;

import java.util.ArrayList;
import java.util.List;

import com.jmp.aula2.dtos.CategoriaDto;

public class ProdutoDto {
	private Long id;
	private String nome;
	private Double preco;
	private List<CategoriaDto> categorias = new ArrayList<>();

	public ProdutoDto() {
		// TODO Auto-generated constructor stub
	}
	public ProdutoDto(Long id, String nome, Double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public ProdutoDto(Produto entidade){
		this.id = entidade.getId();
		this.nome = entidade.getNome();
		this.preco = entidade.getPreco();
		for(Categoria cat : entidade.getCategorias()){
	    	    categorias.add( new CategoriaDto(cat));
		}
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}

	public List<CategoriaDto> getCategorias() {
		return categorias;
	}
	
}