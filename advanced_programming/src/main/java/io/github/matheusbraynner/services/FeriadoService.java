package io.github.matheusbraynner.services;

import java.util.List;

import io.github.matheusbraynner.dto.FeriadoDTO;
import io.github.matheusbraynner.dto.FeriadoFormDTO;

public interface FeriadoService {
	
	FeriadoDTO insert(FeriadoFormDTO body);
	
	List<FeriadoDTO> findAll();
	
	FeriadoDTO findById(Long id);
	
	FeriadoDTO update(Long id, FeriadoFormDTO body);
	
	void delete(Long id);
}
