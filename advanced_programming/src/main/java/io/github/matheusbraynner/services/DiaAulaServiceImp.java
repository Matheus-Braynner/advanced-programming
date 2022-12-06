package io.github.matheusbraynner.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.matheusbraynner.dto.DiaAulaDTO;
import io.github.matheusbraynner.dto.DiaAulaFormDTO;
import io.github.matheusbraynner.dto.FeriadoDTO;
import io.github.matheusbraynner.entities.Curso;
import io.github.matheusbraynner.entities.DiaAula;
import io.github.matheusbraynner.repositories.CursoRepository;
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
	private CursoRepository cursoRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public DiaAulaDTO insert(DiaAulaFormDTO body) {
		if (!checkHolidayDate(body)) {
			throw new FeriadoMatchClassException("Não se pode inserir uma aula em dia de feriado, marque outra data!!");
		}
		Curso curso = cursoRepository.findById(body.getIdCurso()).orElseThrow(
				() -> new ResourceNotFoundException("Não foi encontrado o curso com id : " + body.getIdCurso()));
		DiaAula diaAula = mapper.map(body, DiaAula.class);
		diaAula.setIdCurso(curso);
		DiaAula diaAulaSaved = repository.save(mapper.map(diaAula, DiaAula.class));
		checkDayOfMonth(diaAula, curso);
		return mapper.map(diaAulaSaved, DiaAulaDTO.class);
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
		DiaAula diaAulaSaved = repository.save(diaAula);
		return mapper.map(diaAulaSaved, DiaAulaDTO.class);
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
			if (!feriado.getDataFeriado().after(body.getDiaAula())
					&& !feriado.getDataFeriado().before(body.getDiaAula())) {
				return false;
			}
		}
		return true;
	}

	private List<LocalDate> convertToLocalDate(DiaAula body) {
		List<DiaAula> diaAulaList = repository.findAll();
		List<LocalDate> ldList = new ArrayList<>();
		for(int i = 0; i < diaAulaList.size(); i ++) {
			LocalDate ldAula = diaAulaList.get(i).getDiaAula().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			ldList.add(ldAula);
		}
		return ldList;
	}
	

	private void checkDayOfMonth(DiaAula body, Curso curso) {
		List<LocalDate> ldAula = convertToLocalDate(body);
		List<LocalDate> segunda = ldAula.stream().filter((x) -> x.getDayOfWeek().getValue() == 1).collect(Collectors.toList());
		curso.setSegunda(segunda);
		List<LocalDate> terca = ldAula.stream().filter((x) -> x.getDayOfWeek().getValue() == 2).collect(Collectors.toList());
		curso.setTerca(terca);
		List<LocalDate> quarta = ldAula.stream().filter((x) -> x.getDayOfWeek().getValue() == 3).collect(Collectors.toList());
		curso.setQuarta(quarta);
		List<LocalDate> quinta = ldAula.stream().filter((x) -> x.getDayOfWeek().getValue() == 4).collect(Collectors.toList());
		curso.setQuinta(quinta);
		List<LocalDate> sexta = ldAula.stream().filter((x) -> x.getDayOfWeek().getValue() == 5).collect(Collectors.toList());
		curso.setSexta(sexta);
		List<LocalDate> sabado = ldAula.stream().filter((x) -> x.getDayOfWeek().getValue() == 6).collect(Collectors.toList());
		curso.setSabado(sabado);
		cursoRepository.save(curso);
	}
}
