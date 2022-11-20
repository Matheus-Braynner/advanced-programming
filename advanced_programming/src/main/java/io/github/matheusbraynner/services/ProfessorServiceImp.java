package io.github.matheusbraynner.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.matheusbraynner.dto.ProfessorDTO;
import io.github.matheusbraynner.dto.ProfessorFormDTO;
import io.github.matheusbraynner.entities.Professor;
import io.github.matheusbraynner.repositories.ProfessorRepository;
import io.github.matheusbraynner.services.exceptions.DatabaseException;
import io.github.matheusbraynner.services.exceptions.ResourceNotFoundException;

@Service
public class ProfessorServiceImp implements ProfessorService {
	
	@Autowired
	private ProfessorRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ProfessorDTO insert(ProfessorFormDTO body) {
		Professor professor = repository.save(mapper.map(body, Professor.class));
		return mapper.map(professor, ProfessorDTO.class);
	}

	@Override
	public List<ProfessorDTO> findAll() {
		List<Professor> professorList = repository.findAll();
		List<ProfessorDTO> professorListDTO = professorList.stream().map(x -> new ProfessorDTO(x)).collect(Collectors.toList());
		return professorListDTO;
	}

	@Override
	public ProfessorDTO findById(Long id) {
		Professor professor = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o professor com id : " + id));
		return mapper.map(professor, ProfessorDTO.class);
	}

	@Override
	public ProfessorDTO update(Long id, ProfessorFormDTO body) {
		Professor professor = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o professor com id : " + id));
		professor.setNome(body.getNome());
		professor.setTelefone(body.getTelefone());
		professor.setValorHoraAula(body.getValorHoraAula());
		return mapper.map(professor, ProfessorDTO.class);
	}

	@Override
	public void delete(Long id) {
		try {
			Professor professor = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o professor com id : " + id));
		repository.delete(professor);
		} catch (DatabaseException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}

}