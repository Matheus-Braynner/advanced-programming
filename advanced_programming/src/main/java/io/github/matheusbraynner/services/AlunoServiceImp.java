package io.github.matheusbraynner.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.matheusbraynner.dto.AlunoDTO;
import io.github.matheusbraynner.dto.AlunoFormDTO;
import io.github.matheusbraynner.entities.Aluno;
import io.github.matheusbraynner.entities.Turma;
import io.github.matheusbraynner.repositories.AlunoRepository;
import io.github.matheusbraynner.repositories.TurmaRepository;
import io.github.matheusbraynner.services.exceptions.DatabaseException;
import io.github.matheusbraynner.services.exceptions.ResourceNotFoundException;

@Service
public class AlunoServiceImp implements AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public AlunoDTO insert(AlunoFormDTO body) {
		Turma turma = turmaRepository.findById(body.getTurmaId())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado a turma com o id: " + body.getTurmaId()));
		Aluno aluno = mapper.map(body, Aluno.class);
		aluno.setTurmaId(turma);
		Aluno alunoSaved = repository.save(aluno);
		return mapper.map(alunoSaved, AlunoDTO.class);
	}

	@Override
	public List<AlunoDTO> findAll() {
		List<Aluno> alunoList = repository.findAll();
		List<AlunoDTO> alunoListDTO = alunoList.stream().map(x -> new AlunoDTO(x)).collect(Collectors.toList());
		return alunoListDTO;
	}

	@Override
	public AlunoDTO findById(Long id) {
		Aluno aluno = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o aluno com id : " + id));
		return mapper.map(aluno, AlunoDTO.class);
	}

	@Override
	public AlunoDTO update(Long id, AlunoFormDTO body) {
		Aluno aluno = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o aluno com id : " + id));
		aluno.setNome(body.getNome());
		aluno.setTelefone(body.getTelefone());
		aluno.setEndereco(body.getEndereco());
		aluno.setCpf(body.getCpf());
		Aluno alunoSaved = repository.save(aluno);
		return mapper.map(alunoSaved, AlunoDTO.class);
	}

	@Override
	public void delete(Long id) {
		try {
		Aluno aluno = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o aluno com id : " + id));
		repository.delete(aluno);
		} catch (DatabaseException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}

}
