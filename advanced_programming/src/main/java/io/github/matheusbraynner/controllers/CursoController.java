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

import io.github.matheusbraynner.dto.CursoDTO;
import io.github.matheusbraynner.dto.CursoFormDTO;
import io.github.matheusbraynner.services.CursoService;

@RestController
@RequestMapping(value = "/cursos")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<CursoDTO> insert(@Valid @RequestBody CursoFormDTO body) {
		CursoDTO curso = cursoService.insert(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(curso);
	}
	
	@GetMapping
	public ResponseEntity<List<CursoDTO>> findAll() {
		List<CursoDTO> cursoList = cursoService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(cursoList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CursoDTO> findById(@PathVariable Long id) {
		CursoDTO curso = cursoService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(curso);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CursoDTO> update(@Valid @RequestBody CursoFormDTO body, @PathVariable Long id) {
		CursoDTO curso = cursoService.update(id, body);
		return ResponseEntity.status(HttpStatus.OK).body(curso);
	}
	
	@DeleteMapping(value = "/{id}") 
	@Transactional
	public ResponseEntity<Void> delete (@PathVariable Long id){
		cursoService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	

}