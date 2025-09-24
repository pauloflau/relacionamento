package com.jmp.aula2.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jmp.aula2.entities.ProdutoDto;
import com.jmp.aula2.services.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
	@Autowired
	private ProdutoService service;

	@PostMapping
	public ResponseEntity<ProdutoDto> inserir(@RequestBody ProdutoDto dto) {
		dto = service.inserir(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(dto.getId())
				.toUri();
	
		return ResponseEntity.created(uri).body(dto);
	}
	
}
