package io.github.matheusbraynner.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

public class ProfessorFormDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idProfessor;
	@NotBlank(message = "Campo obrigatório")
	private String nome;
	@NotBlank(message = "Campo obrigatório")
	private String telefone;
	@NotEmpty(message = "Campo obrigatório")
	private Double valorHoraAula;
	
}