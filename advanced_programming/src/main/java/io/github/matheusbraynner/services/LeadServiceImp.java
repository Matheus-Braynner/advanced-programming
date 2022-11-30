package io.github.matheusbraynner.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.matheusbraynner.dto.LeadDTO;
import io.github.matheusbraynner.dto.LeadFormDTO;
import io.github.matheusbraynner.entities.Lead;
import io.github.matheusbraynner.repositories.LeadRepository;
import io.github.matheusbraynner.services.exceptions.DatabaseException;
import io.github.matheusbraynner.services.exceptions.ResourceNotFoundException;

@Service
public class LeadServiceImp implements LeadService {
	
	@Autowired
	private LeadRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public LeadDTO insert(LeadFormDTO body) {
		Lead lead = repository.save(mapper.map(body, Lead.class));
		return mapper.map(lead, LeadDTO.class);
	}

	@Override
	public List<LeadDTO> findAll() {
		List<Lead> leadList = repository.findAll();
		List<LeadDTO> leadListDTO = leadList.stream().map(x -> new LeadDTO(x)).collect(Collectors.toList());
		return leadListDTO;
	}

	@Override
	public LeadDTO findById(Long id) {
		Lead lead = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o lead com id : " + id));
		return mapper.map(lead, LeadDTO.class);
	}

	@Override
	public LeadDTO update(Long id, LeadFormDTO body) {
		Lead lead = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o lead com id : " + id));
		lead.setNome(body.getNome());
		lead.setTelefone(body.getTelefone());
		lead.setStatus(body.getStatus());
		lead.setDataCadastro(body.getDataCadastro());
		lead.setDataNovoContato(body.getDataNovoContato());
		lead.setObservacao(body.getObservacao());
		Lead leadSaved = repository.save(lead);
		return mapper.map(leadSaved, LeadDTO.class);
	}

	@Override
	public void delete(Long id) {
		try {
		Lead lead = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o lead com id : " + id));
		repository.delete(lead);
		} catch (DatabaseException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}

}
