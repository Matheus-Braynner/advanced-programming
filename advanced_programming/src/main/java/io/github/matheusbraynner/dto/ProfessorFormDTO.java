package io.github.matheusbraynner.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

public class ProfessorFormDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank(message = "Campo obrigatório")
	private String nome;
	@NotBlank(message = "Campo obrigatório")
	private String telefone;
	@NotNull(message = "Campo obrigatório")
	private Double valorHoraAula;
	
}