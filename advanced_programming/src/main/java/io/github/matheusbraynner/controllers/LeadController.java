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

import io.github.matheusbraynner.dto.LeadDTO;
import io.github.matheusbraynner.dto.LeadFormDTO;
import io.github.matheusbraynner.services.LeadService;

@RestController
@RequestMapping(value = "/leads")
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<LeadDTO> insert(@Valid @RequestBody LeadFormDTO body) {
		LeadDTO lead = leadService.insert(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(lead);
	}
	
	@GetMapping
	public ResponseEntity<List<LeadDTO>> findAll() {
		List<LeadDTO> leadList = leadService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(leadList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LeadDTO> findById(@PathVariable Long id) {
		LeadDTO lead = leadService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(lead);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<LeadDTO> update(@Valid @RequestBody LeadFormDTO body, @PathVariable Long id) {
		LeadDTO lead = leadService.update(id, body);
		return ResponseEntity.status(HttpStatus.OK).body(lead);
	}
	
	@DeleteMapping(value = "/{id}") 
	@Transactional
	public ResponseEntity<Void> delete (@PathVariable Long id){
		leadService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	

}