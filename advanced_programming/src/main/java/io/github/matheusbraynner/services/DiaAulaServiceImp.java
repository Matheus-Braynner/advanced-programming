package io.github.matheusbraynner.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.matheusbraynner.dto.DiaAulaDTO;
import io.github.matheusbraynner.dto.DiaAulaFormDTO;
import io.github.matheusbraynner.dto.FeriadoDTO;
import io.github.matheusbraynner.entities.DiaAula;
import io.github.matheusbraynner.repositories.DiaAulaRepository;
import io.github.matheusbraynner.services.exceptions.DatabaseException;
import io.github.matheusbraynner.services.exceptions.FeriadoMatchClassException;
import io.github.matheusbraynner.services.exceptions.ResourceNotFoundException;

@Service
public class DiaAulaServiceImp implements DiaAulaService {

	@Autowired
	private DiaAulaRepository repository;


	@Autowired
	private FeriadoService feriadoService;

	@Autowired
	private ModelMapper mapper;

	@Override
	public DiaAulaDTO insert(DiaAulaFormDTO body) {
		if (!checkHolidayDate(body)) {
			throw new FeriadoMatchClassException("Não se pode inserir uma aula em dia de feriado, marque outra data!!");
		}
		DiaAula diaAula = repository.save(mapper.map(body, DiaAula.class));
		return mapper.map(diaAula, DiaAulaDTO.class);
	}

	@Override
	public List<DiaAulaDTO> findAll() {
		List<DiaAula> diaAulaList = repository.findAll();
		List<DiaAulaDTO> diaAulaListDTO = diaAulaList.stream().map(x -> new DiaAulaDTO(x)).collect(Collectors.toList());
		return diaAulaListDTO;
	}

	@Override
	public DiaAulaDTO findById(Long id) {
		DiaAula diaAula = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o dia da aula com id : " + id));
		return mapper.map(diaAula, DiaAulaDTO.class);
	}

	@Override
	public DiaAulaDTO update(Long id, DiaAulaFormDTO body) {
		if (!checkHolidayDate(body)) {
			throw new FeriadoMatchClassException("Não se pode inserir uma aula em dia de feriado, marque outra data!!");
		}
		DiaAula diaAula = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o dia da aula com id : " + id));
		diaAula.setDiaAula(body.getDiaAula());
		diaAula.setIdCurso(body.getIdCurso());
		return mapper.map(diaAula, DiaAulaDTO.class);
	}

	@Override
	public void delete(Long id) {
		try {
			DiaAula diaAula = repository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Não foi encontrado o dia da aula com id : " + id));
			repository.delete(diaAula);
		} catch (DatabaseException e) {
			throw new DatabaseException(e.getMessage());
		}

	}

	private Boolean checkHolidayDate(DiaAulaFormDTO body) {
		List<FeriadoDTO> feriadoList = feriadoService.findAll();

		for (FeriadoDTO feriado : feriadoList) {
			if (!feriado.getDataFeriado().after(body.getDiaAula()) && !feriado.getDataFeriado().before(body.getDiaAula())) {
				return false;
			}
		}
		return true;
	}
}
