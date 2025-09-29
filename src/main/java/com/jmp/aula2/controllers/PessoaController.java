package com.jmp.aula2.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jmp.aula2.dtos.PessoaDepartamentoDto;
import com.jmp.aula2.dtos.PessoaDto;
import com.jmp.aula2.dtos.PessoaMinDto;
import com.jmp.aula2.services.PessoaService;

@RestController
@RequestMapping(value="/pessoa")
public class PessoaController {

	@Autowired
	PessoaService pessoaService;
	
	@GetMapping(value = "/{id}/min")
	public ResponseEntity<PessoaMinDto> findByIdMin(@PathVariable Long id) {
		PessoaMinDto obj = pessoaService.findByIdMin(id);		
		return ResponseEntity.ok(obj);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaDepartamentoDto> findByIdWithDepartment(@PathVariable Long id) {
		PessoaDepartamentoDto obj = pessoaService.findByIdComDepartamento(id);		
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaDepartamentoDto>> findEmployeesWithDepartments() {
		List<PessoaDepartamentoDto> list = pessoaService.findPessoaComDepartamento();		
		return ResponseEntity.ok(list);
	}
	
	
	//@PostMapping
	public ResponseEntity<PessoaDepartamentoDto> inserir(@RequestBody PessoaDepartamentoDto dto){
		dto = pessoaService.inserir(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("{/id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	 @PostMapping
	    public ResponseEntity<PessoaDto> inserir(@RequestBody PessoaDto dto){
		dto = pessoaService.inserir(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(dto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(dto); 
	}
}
