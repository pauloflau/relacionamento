package com.jmp.aula2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jmp.aula2.dtos.DepartamentoDto;
import com.jmp.aula2.dtos.PessoaMinDto;
import com.jmp.aula2.entities.Departamento;
import com.jmp.aula2.entities.Pessoa;
import com.jmp.aula2.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Transactional(readOnly = true)
	public List<DepartamentoDto> findAll() {
		List<Departamento> result = departamentoRepository.findAll();
		List<DepartamentoDto> listaDto = new ArrayList<>();
		
		for(Departamento d: result) {
			listaDto.add(new DepartamentoDto(d));
		}
		return listaDto;
	}
	
	@Transactional(readOnly = true)
	public DepartamentoDto findById(Long id) {
		Optional<Departamento> result = departamentoRepository.findById(id);
		return new DepartamentoDto(result.get());
	}

	@Transactional(readOnly = true)
	public List<PessoaMinDto> findPessoaByDepartamento(Long id) {
		Optional<Departamento> result = departamentoRepository.findById(id);
		List<Pessoa> listaPessoa = result.get().getPesssoas();
		List<PessoaMinDto> listaDto = new ArrayList<>();

		for (Pessoa p : listaPessoa) {
			listaDto.add(new PessoaMinDto(p));
		}

		return listaDto;
	}
}
