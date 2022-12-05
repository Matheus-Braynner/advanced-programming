package io.github.matheusbraynner.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.matheusbraynner.dto.FeriadoDTO;
import io.github.matheusbraynner.dto.FeriadoFormDTO;
import io.github.matheusbraynner.entities.Feriado;
import io.github.matheusbraynner.repositories.FeriadoRepository;
import io.github.matheusbraynner.services.exceptions.DatabaseException;
import io.github.matheusbraynner.services.exceptions.ResourceNotFoundException;

@Service
public class FeriadoServiceImp implements FeriadoService {
	
	@Autowired
	private FeriadoRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public FeriadoDTO insert(FeriadoFormDTO body) {
		Feriado feriado = repository.save(mapper.map(body, Feriado.class));
		return mapper.map(feriado, FeriadoDTO.class);
	}

	@Override
	public List<FeriadoDTO> findAll() {
		List<Feriado> feriadoList = repository.findAll();
		List<FeriadoDTO> feriadoListDTO = feriadoList.stream().map(x -> new FeriadoDTO(x)).collect(Collectors.toList());
		return feriadoListDTO;
	}

	@Override
	public FeriadoDTO findById(Long id) {
		Feriado feriado = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o feriado com id : " + id));
		return mapper.map(feriado, FeriadoDTO.class);
	}

	@Override
	public FeriadoDTO update(Long id, FeriadoFormDTO body) {
		Feriado feriado = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o feriado com id : " + id));
		feriado.setDataFeriado(body.getDataFeriado());
		feriado.setDescricao(body.getDescricao());
		Feriado feriadoSaved = repository.save(feriado);
		return mapper.map(feriadoSaved, FeriadoDTO.class);
	}

	@Override
	public void delete(Long id) {
		try {
		Feriado feriado = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o feriado com id : " + id));
		repository.delete(feriado);
		} catch (DatabaseException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}

}
