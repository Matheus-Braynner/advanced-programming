package io.github.matheusbraynner.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.github.matheusbraynner.entities.enums.Turno;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CursoFormDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank(message = "Campo obrigatório")
	private String nomeCurso;
	@NotNull(message = "Campo obrigatório")
	private Double cargaHorariaAula;
	@NotNull(message = "Campo obrigatório")
	private Double cargaHorariaTotal;
	@NotNull(message = "obligatory field")
	private Turno turno;
	@NotNull(message = "Campo obrigatório")
	private Double valor;
}
