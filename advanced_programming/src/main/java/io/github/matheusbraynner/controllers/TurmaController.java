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

import io.github.matheusbraynner.dto.TurmaDTO;
import io.github.matheusbraynner.dto.TurmaFormDTO;
import io.github.matheusbraynner.services.TurmaService;

@RestController
@RequestMapping(value = "/turmas")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<TurmaDTO> insert(@Valid @RequestBody TurmaFormDTO body) {
		TurmaDTO turma = turmaService.insert(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(turma);
	}
	
	@GetMapping
	public ResponseEntity<List<TurmaDTO>> findAll() {
		List<TurmaDTO> turmaList = turmaService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(turmaList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TurmaDTO> findById(@PathVariable Long id) {
		TurmaDTO turma = turmaService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(turma);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TurmaDTO> update(@Valid @RequestBody TurmaFormDTO body, @PathVariable Long id) {
		TurmaDTO turma = turmaService.update(id, body);
		return ResponseEntity.status(HttpStatus.OK).body(turma);
	}
	
	@DeleteMapping(value = "/{id}") 
	@Transactional
	public ResponseEntity<Void> delete (@PathVariable Long id){
		turmaService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	

}