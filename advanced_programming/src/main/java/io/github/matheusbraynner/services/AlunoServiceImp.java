package io.github.matheusbraynner.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.matheusbraynner.dto.AlunoDTO;
import io.github.matheusbraynner.dto.AlunoFormDTO;
import io.github.matheusbraynner.entities.Aluno;
import io.github.matheusbraynner.repositories.AlunoRepository;
import io.github.matheusbraynner.services.exceptions.DatabaseException;
import io.github.matheusbraynner.services.exceptions.ResourceNotFoundException;

@Service
public class AlunoServiceImp implements AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public AlunoDTO insert(AlunoFormDTO body) {
		Aluno aluno = repository.save(mapper.map(body, Aluno.class));
		return mapper.map(aluno, AlunoDTO.class);
	}

	@Override
	public List<AlunoDTO> findAll() {
		List<Aluno> alunoList = repository.findAll();
		List<AlunoDTO> alunoListDTO = alunoList.stream().map(x -> new AlunoDTO()).collect(Collectors.toList());
		return alunoListDTO;
	}

	@Override
	public AlunoDTO findById(Integer id) {
		Aluno aluno = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o aluno com id : " + id));
		return mapper.map(aluno, AlunoDTO.class);
	}

	@Override
	public AlunoDTO update(Integer id, AlunoFormDTO body) {
		Aluno aluno = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o aluno com id : " + id));
		aluno.setNome(body.getNome());
		aluno.setTelefone(body.getTelefone());
		aluno.setEndereco(body.getEndereco());
		aluno.setCpf(body.getCpf());
		return mapper.map(aluno, AlunoDTO.class);
	}

	@Override
	public void delete(Integer id) {
		try {
		Aluno aluno = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o aluno com id : " + id));
		repository.delete(aluno);
		} catch (DatabaseException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}

}
