package io.github.matheusbraynner.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.matheusbraynner.dto.CursoDTO;
import io.github.matheusbraynner.dto.CursoFormDTO;
import io.github.matheusbraynner.entities.Curso;
import io.github.matheusbraynner.repositories.CursoRepository;
import io.github.matheusbraynner.services.exceptions.DatabaseException;
import io.github.matheusbraynner.services.exceptions.ResourceNotFoundException;

@Service
public class CursoServiceImp implements CursoService {

	@Autowired
	private CursoRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CursoDTO insert(CursoFormDTO body) {
		Curso curso = mapper.map(body, Curso.class);
		Curso cursoSaved = repository.save(curso);
		return mapper.map(cursoSaved, CursoDTO.class);
	}

	@Override
	public List<CursoDTO> findAll() {
		List<Curso> cursoList = repository.findAll();
		List<CursoDTO> cursoListDTO = cursoList.stream().map(x -> new CursoDTO(x)).collect(Collectors.toList());
		return cursoListDTO;
	}

	@Override
	public CursoDTO findById(Long id) {
		Curso curso = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o curso com id : " + id));
		return mapper.map(curso, CursoDTO.class);
	}

	@Override
	public CursoDTO update(Long id, CursoFormDTO body) {
		Curso curso = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o curso com id : " + id));
		curso.setNomeCurso(body.getNomeCurso());
		curso.setCargaHorariaAula(body.getCargaHorariaAula());
		curso.setCargaHorariaTotal(body.getCargaHorariaTotal());
		curso.setTurno(body.getTurno());
		curso.setValor(body.getValor());
		Curso cursoUpdated = repository.save(curso);
		return mapper.map(cursoUpdated, CursoDTO.class);
	}

	@Override
	public void delete(Long id) {
		try {
			Curso curso = repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o curso com id : " + id));
			repository.delete(curso);
		} catch (DatabaseException e) {
			throw new DatabaseException(e.getMessage());
		}

	}
}
