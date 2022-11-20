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

import io.github.matheusbraynner.dto.ProfessorDTO;
import io.github.matheusbraynner.dto.ProfessorFormDTO;
import io.github.matheusbraynner.services.ProfessorService;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProfessorDTO> insert(@Valid @RequestBody ProfessorFormDTO body) {
		ProfessorDTO professor = professorService.insert(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(professor);
	}
	
	@GetMapping
	public ResponseEntity<List<ProfessorDTO>> findAll() {
		List<ProfessorDTO> professorList = professorService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(professorList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProfessorDTO> findById(@PathVariable Long id) {
		ProfessorDTO professor = professorService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(professor);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProfessorDTO> update(@Valid @RequestBody ProfessorFormDTO body, @PathVariable Long id) {
		ProfessorDTO professor = professorService.update(id, body);
		return ResponseEntity.status(HttpStatus.OK).body(professor);
	}
	
	@DeleteMapping(value = "/{id}") 
	@Transactional
	public ResponseEntity<Void> delete (@PathVariable Long id){
		professorService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	

}