package com.jmp.aula2.dtos;

import com.jmp.aula2.entities.Pessoa;

public class PessoaMinDto {
	private Long id;
	private String nome;
	private Double salario;
	public PessoaMinDto(Long id, String nome, Double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
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
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public PessoaMinDto(Pessoa entidade) {
		
		id = entidade.getId();
		nome = entidade.getNome();
		salario = entidade.getSalario();
	}
	
	
}
