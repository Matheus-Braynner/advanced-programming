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

import io.github.matheusbraynner.dto.DiaAulaDTO;
import io.github.matheusbraynner.dto.DiaAulaFormDTO;
import io.github.matheusbraynner.services.DiaAulaService;

@RestController
@RequestMapping(value = "/diasAulas")
public class DiaAulaController {
	
	@Autowired
	private DiaAulaService diaAulaService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DiaAulaDTO> insert(@Valid @RequestBody DiaAulaFormDTO body) {
		DiaAulaDTO diaAula = diaAulaService.insert(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(diaAula);
	}
	
	@GetMapping
	public ResponseEntity<List<DiaAulaDTO>> findAll() {
		List<DiaAulaDTO> diaAulaList = diaAulaService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(diaAulaList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DiaAulaDTO> findById(@PathVariable Long id) {
		DiaAulaDTO diaAula = diaAulaService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(diaAula);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<DiaAulaDTO> update(@Valid @RequestBody DiaAulaFormDTO body, @PathVariable Long id) {
		DiaAulaDTO diaAula = diaAulaService.update(id, body);
		return ResponseEntity.status(HttpStatus.OK).body(diaAula);
	}
	
	@DeleteMapping(value = "/{id}") 
	@Transactional
	public ResponseEntity<Void> delete (@PathVariable Long id){
		diaAulaService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
