package io.github.matheusbraynner.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.matheusbraynner.dto.TurmaDTO;
import io.github.matheusbraynner.dto.TurmaFormDTO;
import io.github.matheusbraynner.entities.Curso;
import io.github.matheusbraynner.entities.Professor;
import io.github.matheusbraynner.entities.Turma;
import io.github.matheusbraynner.repositories.CursoRepository;
import io.github.matheusbraynner.repositories.ProfessorRepository;
import io.github.matheusbraynner.repositories.TurmaRepository;
import io.github.matheusbraynner.services.exceptions.DatabaseException;
import io.github.matheusbraynner.services.exceptions.ResourceNotFoundException;

@Service
public class TurmaServiceImp implements TurmaService {
	
	@Autowired
	private TurmaRepository repository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public TurmaDTO insert(TurmaFormDTO body) {
		Curso curso = cursoRepository.findById(body.getCursoId())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o curso com id: " + body.getCursoId()));
		Professor professor = professorRepository.findById(body.getProfessorId())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o curso com id: " + body.getProfessorId()));
		Turma turma = mapper.map(body, Turma.class);
		turma.setCursoId(curso);
		turma.setProfessorId(professor);
		Turma turmaSaved = repository.save(turma);
		return mapper.map(turmaSaved, TurmaDTO.class);
	}

	@Override
	public List<TurmaDTO> findAll() {
		List<Turma> turmaList = repository.findAll();
		List<TurmaDTO> turmaListDTO = turmaList.stream().map(x -> new TurmaDTO(x)).collect(Collectors.toList());
		return turmaListDTO;
	}

	@Override
	public TurmaDTO findById(Long id) {
		Turma turma = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado a turma com id : " + id));
		return mapper.map(turma, TurmaDTO.class);
	}

	@Override
	public TurmaDTO update(Long id, TurmaFormDTO body) {
		Turma turma = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado a turma com id : " + id));
		turma.setValor(body.getValor());
		Turma turmaSaved = repository.save(turma);
		return mapper.map(turmaSaved, TurmaDTO.class);
	}

	@Override
	public void delete(Long id) {
		try {
		Turma turma = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado a turma com id : " + id));
		repository.delete(turma);
		} catch (DatabaseException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}

}
