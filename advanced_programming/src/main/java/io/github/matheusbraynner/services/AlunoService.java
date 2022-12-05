package io.github.matheusbraynner.services;

import java.util.List;

import io.github.matheusbraynner.dto.AlunoDTO;
import io.github.matheusbraynner.dto.AlunoFormDTO;

public interface AlunoService {
	
	AlunoDTO insert(AlunoFormDTO body);
	
	List<AlunoDTO> findAll();
	
	AlunoDTO findById(Long id);
	
	AlunoDTO update(Long id, AlunoFormDTO body);
	
	void delete(Long id);
}
