package com.jmp.aula2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmp.aula2.dtos.PessoaDepartamentoDto;
import com.jmp.aula2.dtos.PessoaDto;
import com.jmp.aula2.entities.Departamento;
import com.jmp.aula2.entities.Pessoa;
import com.jmp.aula2.repositories.DepartamentoRepository;
import com.jmp.aula2.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	@Autowired
	private DepartamentoRepository departamentoRepository;

	public PessoaDepartamentoDto inserir(PessoaDepartamentoDto dto) {
		Pessoa entidade = new Pessoa();
		entidade.setNome(dto.getNome());
		entidade.setSalario(dto.getSalario());

		Departamento dept = departamentoRepository.getReferenceById(dto.getDepartamento().getId());
		// Departamento dept = new Departamento();
		// dept.setId(dto.getDepartamento().getId());

		entidade.setDepartamento(dept);

		entidade = repository.save(entidade);

		return new PessoaDepartamentoDto(entidade);
	}

	public PessoaDto inserir(PessoaDto dto) {
		Pessoa entidade = new Pessoa();
		entidade.setNome(dto.getNome());
		entidade.setSalario(dto.getSalario());

		Departamento dept = departamentoRepository.getReferenceById(dto.getDepartamentoId());

		entidade.setDepartamento(dept);
		entidade = repository.save(entidade);
		return new PessoaDto(entidade);
	}

}
