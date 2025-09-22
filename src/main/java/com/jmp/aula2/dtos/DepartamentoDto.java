package com.jmp.aula2.dtos;

import com.jmp.aula2.entities.Departamento;

public class DepartamentoDto {
	private Long id;
	private String nome;
	public DepartamentoDto() {
		// TODO Auto-generated constructor stub
	}
	public DepartamentoDto(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public DepartamentoDto(Departamento entidade) {
		id = entidade.getId();
		nome = entidade.getNome();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
