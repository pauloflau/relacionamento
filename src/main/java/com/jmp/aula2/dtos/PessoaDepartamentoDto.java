package com.jmp.aula2.dtos;

import com.jmp.aula2.entities.Pessoa;

public class PessoaDepartamentoDto {
	private Long id;
	private String nome;
	private Double salario;
	
	private DepartamentoDto departamento;
	
	public PessoaDepartamentoDto() {
		// TODO Auto-generated constructor stub
	}

	public PessoaDepartamentoDto(Long id, String nome, Double salario, DepartamentoDto departamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
		this.departamento = departamento;
	}
	
	public PessoaDepartamentoDto(Pessoa entidade) {
		id = entidade.getId();
		nome = entidade.getNome();
		salario = entidade.getSalario();
		departamento = new DepartamentoDto(entidade.getDepartamento());
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

	public DepartamentoDto getDepartamento() {
		return departamento;
	}
	
	
}
