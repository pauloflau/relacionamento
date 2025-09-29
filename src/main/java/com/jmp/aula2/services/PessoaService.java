package com.jmp.aula2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jmp.aula2.dtos.PessoaDepartamentoDto;
import com.jmp.aula2.dtos.PessoaDto;
import com.jmp.aula2.dtos.PessoaMinDto;
import com.jmp.aula2.entities.Departamento;
import com.jmp.aula2.entities.Pessoa;
import com.jmp.aula2.repositories.DepartamentoRepository;
import com.jmp.aula2.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Transactional(readOnly = true) 									
	public PessoaMinDto findByIdMin(Long id) {
		Optional<Pessoa> result = pessoaRepository.findById(id);
		return new PessoaMinDto(result.get());
	}

	@Transactional(readOnly = true)
	public PessoaDepartamentoDto findByIdComDepartamento(Long id) {
		Optional<Pessoa> result = pessoaRepository.findById(id);
		return new PessoaDepartamentoDto(result.get());
	}

	@Transactional(readOnly = true)
	public List<PessoaDepartamentoDto> findPessoaComDepartamento() {
		List<Pessoa> listaPessoa = pessoaRepository.findAll();

		List<PessoaDepartamentoDto> listaDto = new ArrayList<>();

		for (Pessoa p : listaPessoa) {
			listaDto.add(new PessoaDepartamentoDto(p));
		}

		return listaDto;
	}

	public PessoaDepartamentoDto inserir(PessoaDepartamentoDto dto) {
		Pessoa entidade = new Pessoa();
		entidade.setNome(dto.getNome());
		entidade.setSalario(dto.getSalario());

		Departamento dept = departamentoRepository.getReferenceById(dto.getDepartamento().getId());
		// Departamento dept = new Departamento();
		// dept.setId(dto.getDepartamento().getId());

		entidade.setDepartamento(dept);

		entidade = pessoaRepository.save(entidade);

		return new PessoaDepartamentoDto(entidade);
	}

	public PessoaDto inserir(PessoaDto dto) {
		Pessoa entidade = new Pessoa();
		entidade.setNome(dto.getNome());
		entidade.setSalario(dto.getSalario());

		Departamento dept = departamentoRepository.getReferenceById(dto.getDepartamentoId());

		entidade.setDepartamento(dept);
		entidade = pessoaRepository.save(entidade);
		return new PessoaDto(entidade);
	}

}
