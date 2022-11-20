package io.github.matheusbraynner.services;

import java.util.List;

import io.github.matheusbraynner.dto.ProfessorDTO;
import io.github.matheusbraynner.dto.ProfessorFormDTO;

public interface ProfessorService {
	
	ProfessorDTO insert(ProfessorFormDTO body);
	
	List<ProfessorDTO> findAll();
	
	ProfessorDTO findById(Long id);
	
	ProfessorDTO update(Long id, ProfessorFormDTO body);
	
	void delete(Long id);
}