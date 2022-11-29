package io.github.matheusbraynner.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.matheusbraynner.entities.Curso;
import io.github.matheusbraynner.entities.DiaAula;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiaAulaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Curso idCurso;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date diaAula;
	
	public DiaAulaDTO (DiaAula diaAula) {
		this.id = diaAula.getId();
		this.idCurso = diaAula.getIdCurso();
		this.diaAula = diaAula.getDiaAula();	
	}
}
