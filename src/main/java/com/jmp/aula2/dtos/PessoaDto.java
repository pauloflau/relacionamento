package com.jmp.aula2.dtos;

import com.jmp.aula2.entities.Pessoa;

public class PessoaDto {
	private Long id;
	private String nome;
	private Double salario;
	private Long departamentoId;
	
	public PessoaDto() {
		// TODO Auto-generated constructor stub
	}
	
	public PessoaDto(Long id, String nome, Double salario, Long departamentoId) {
		super();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
		this.departamentoId = departamentoId;
	}
	
	public PessoaDto(Pessoa entidade) {
		id = entidade.getId();
		nome = entidade.getNome();
		salario=entidade.getSalario();
		departamentoId = entidade.getDepartamento().getId();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Double getSalario() {
		return salario;
	}

	public Long getDepartamentoId() {
		return departamentoId;
	}
	
}
