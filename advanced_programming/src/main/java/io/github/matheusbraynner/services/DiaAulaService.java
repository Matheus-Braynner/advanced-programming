package io.github.matheusbraynner.services;

import java.util.List;

import io.github.matheusbraynner.dto.DiaAulaDTO;
import io.github.matheusbraynner.dto.DiaAulaFormDTO;

public interface DiaAulaService {
	
	DiaAulaDTO insert(DiaAulaFormDTO body);
	
	List<DiaAulaDTO> findAll();
	
	DiaAulaDTO findById(Long id);
	
	DiaAulaDTO update(Long id, DiaAulaFormDTO body);
	
	void delete(Long id);
}
