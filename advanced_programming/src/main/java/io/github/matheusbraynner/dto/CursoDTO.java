package io.github.matheusbraynner.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.matheusbraynner.entities.Curso;
import io.github.matheusbraynner.entities.DiaAula;
import io.github.matheusbraynner.entities.Turma;
import io.github.matheusbraynner.entities.enums.Turno;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CursoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nomeCurso;
	private Double cargaHorariaAula;
	private Double cargaHorariaTotal;
	private Turno turno;
	private Double valor;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private List<LocalDate> segunda = new ArrayList<LocalDate>();
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private List<LocalDate> terça = new ArrayList<LocalDate>();
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private List<LocalDate> quarta = new ArrayList<LocalDate>();
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private List<LocalDate> quinta = new ArrayList<LocalDate>();
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private List<LocalDate> sexta = new ArrayList<LocalDate>();
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private List<LocalDate> sabado = new ArrayList<LocalDate>();
	private List<DiaAula> diasAulas;
	private List<Turma> turmas;
	
	public CursoDTO (Curso curso) {
		this.id = curso.getId();
		this.nomeCurso = curso.getNomeCurso();
		this.cargaHorariaAula = curso.getCargaHorariaAula();
		this.cargaHorariaTotal = curso.getCargaHorariaTotal();
		this.turno = curso.getTurno();
		this.valor = curso.getValor();
		this.segunda = curso.getSegunda();
		this.terça = curso.getTerca();
		this.quarta = curso.getQuarta();
		this.quinta = curso.getQuinta();
		this.sexta = curso.getSexta();
		this.sabado = curso.getSabado();
		this.diasAulas = curso.getDiasAulas();
		this.turmas = curso.getTurmas();
	}
}
