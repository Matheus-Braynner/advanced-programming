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

import io.github.matheusbraynner.dto.FeriadoDTO;
import io.github.matheusbraynner.dto.FeriadoFormDTO;
import io.github.matheusbraynner.services.FeriadoService;

@RestController
@RequestMapping(value = "/feriados")
public class FeriadoController {

	@Autowired
	private FeriadoService feriadoService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<FeriadoDTO> insert(@Valid @RequestBody FeriadoFormDTO body) {
		FeriadoDTO feriado = feriadoService.insert(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(feriado);
	}
	
	@GetMapping
	public ResponseEntity<List<FeriadoDTO>> findAll() {
		List<FeriadoDTO> feriadoList = feriadoService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(feriadoList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FeriadoDTO> findById(@PathVariable Long id) {
		FeriadoDTO feriado = feriadoService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(feriado);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<FeriadoDTO> update(@Valid @RequestBody FeriadoFormDTO body, @PathVariable Long id) {
		FeriadoDTO feriado = feriadoService.update(id, body);
		return ResponseEntity.status(HttpStatus.OK).body(feriado);
	}
	
	@DeleteMapping(value = "/{id}") 
	@Transactional
	public ResponseEntity<Void> delete (@PathVariable Long id){
		feriadoService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
