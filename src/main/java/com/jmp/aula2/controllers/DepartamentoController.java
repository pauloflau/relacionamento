package com.jmp.aula2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmp.aula2.dtos.DepartamentoDto;
import com.jmp.aula2.dtos.PessoaMinDto;
import com.jmp.aula2.entities.Departamento;
import com.jmp.aula2.services.DepartamentoService;

@RestController
@RequestMapping(value="/departamento")
public class DepartamentoController {

	@Autowired
	DepartamentoService departamentoService;
	
	@GetMapping
	public ResponseEntity<List<DepartamentoDto>> findAll() {
		List<DepartamentoDto> result = departamentoService.findAll();		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DepartamentoDto> findById(@PathVariable Long id) {
		DepartamentoDto obj = departamentoService.findById(id);		
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping(value = "/{id}/pessoa")
	public ResponseEntity<List<PessoaMinDto>> findEmployeesByDepartment(@PathVariable Long id) {
		List<PessoaMinDto> list = departamentoService.findPessoaByDepartamento(id);		
		return ResponseEntity.ok(list);
	}
}
