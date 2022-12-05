package io.github.matheusbraynner.services;

import java.util.List;

import io.github.matheusbraynner.dto.CursoDTO;
import io.github.matheusbraynner.dto.CursoFormDTO;

public interface CursoService {
	
	CursoDTO insert(CursoFormDTO body);
	
	List<CursoDTO> findAll();
	
	CursoDTO findById(Long id);
	
	CursoDTO update(Long id, CursoFormDTO body);
	
	void delete(Long id);
}
