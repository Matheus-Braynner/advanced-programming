package io.github.matheusbraynner.services;

import java.util.List;

import io.github.matheusbraynner.dto.LeadDTO;
import io.github.matheusbraynner.dto.LeadFormDTO;

public interface LeadService {
	
	LeadDTO insert(LeadFormDTO body);
	
	List<LeadDTO> findAll();
	
	LeadDTO findById(Long id);
	
	LeadDTO update(Long id, LeadFormDTO body);
	
	void delete(Long id);
}
