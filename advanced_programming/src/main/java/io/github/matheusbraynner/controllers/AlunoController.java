package io.github.matheusbraynner.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.matheusbraynner.dto.AlunoDTO;
import io.github.matheusbraynner.dto.AlunoFormDTO;
import io.github.matheusbraynner.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<AlunoDTO> insert(@Valid @RequestBody AlunoFormDTO body) {
		AlunoDTO aluno = alunoService.insert(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
	}
	
	@GetMapping
	public ResponseEntity<List<AlunoDTO>> findAll() {
		List<AlunoDTO> alunoList = alunoService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(alunoList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AlunoDTO> findById(@PathVariable Integer id) {
		AlunoDTO aluno = alunoService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(aluno);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AlunoDTO> update(@Valid @RequestBody AlunoFormDTO body, @PathVariable Integer id) {
		AlunoDTO aluno = alunoService.update(id, body);
		return ResponseEntity.status(HttpStatus.OK).body(aluno);
	}
	
	@DeleteMapping(value = "/{id}") 
	@Transactional
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		alunoService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	

}
