package io.github.matheusbraynner.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TurmaFormDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotNull(message = "Campo obrigatório")
	private Double valor;
	private Long cursoId;
	private Long professorId;

}
