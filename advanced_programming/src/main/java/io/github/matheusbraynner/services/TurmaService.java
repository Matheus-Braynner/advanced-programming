package io.github.matheusbraynner.services;

import java.util.List;

import io.github.matheusbraynner.dto.TurmaDTO;
import io.github.matheusbraynner.dto.TurmaFormDTO;

public interface TurmaService {
	
	TurmaDTO insert(TurmaFormDTO body);
	
	List<TurmaDTO> findAll();
	
	TurmaDTO findById(Long id);
	
	TurmaDTO update(Long id, TurmaFormDTO body);
	
	void delete(Long id);
}