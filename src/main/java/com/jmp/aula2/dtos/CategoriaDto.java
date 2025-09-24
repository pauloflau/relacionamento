package com.jmp.aula2.dtos;

import java.util.HashSet;
import java.util.Set;

import com.jmp.aula2.entities.Categoria;
import com.jmp.aula2.entities.Produto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

public class CategoriaDto {
	private Long id;
	private String nome;
	
   @ManyToMany(mappedBy = "departamento") 
   @JoinTable(name = "tb_produto_categoria",
		joinColumns = @JoinColumn(name="produto_id"),
		inverseJoinColumns = @JoinColumn(name="categoria_id"))
   private Set<Produto> Categorias = new HashSet<>(); 
   
   public CategoriaDto() {
	// TODO Auto-generated constructor stub
   }

   public CategoriaDto(Long id, String nome, Set<Produto> categorias) {
	super();
	this.id = id;
	this.nome = nome;
	Categorias = categorias;
   }

   public CategoriaDto(Categoria entidade) {
	id = entidade.getId();
	nome = entidade.getNome();	
   }

   public Long getId() {
	return id;
   }

   public String getNome() {
	return nome;
   }


   
   
}
