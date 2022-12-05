package io.github.matheusbraynner.dto;

import java.io.Serializable;
import java.util.List;

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
	private List<DiaAula> diasAulas;
	private List<Turma> turmas;
	
	public CursoDTO (Curso curso) {
		this.id = curso.getId();
		this.nomeCurso = curso.getNomeCurso();
		this.cargaHorariaAula = curso.getCargaHorariaAula();
		this.cargaHorariaTotal = curso.getCargaHorariaTotal();
		this.turno = curso.getTurno();
		this.valor = curso.getValor();
		this.diasAulas = curso.getDiasAulas();
		this.turmas = curso.getTurmas();
	}
}
