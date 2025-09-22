package com.jmp.aula2.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jmp.aula2.dtos.PessoaDepartamentoDto;
import com.jmp.aula2.dtos.PessoaDto;
import com.jmp.aula2.services.PessoaService;

@RestController
@RequestMapping(value="/pessoa")
public class PessoaController {

	@Autowired
	PessoaService service;
	
	//@PostMapping
	public ResponseEntity<PessoaDepartamentoDto> inserir(@RequestBody PessoaDepartamentoDto dto){
		dto = service.inserir(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("{/id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	 @PostMapping
	    public ResponseEntity<PessoaDto> inserir(@RequestBody PessoaDto dto){
		dto = service.inserir(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(dto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(dto); 
	}
}
