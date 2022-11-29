package io.github.matheusbraynner.dto;

import java.io.Serializable;

import io.github.matheusbraynner.entities.Professor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

public class ProfessorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String telefone;
	private Double valorHoraAula;
	
	public ProfessorDTO (Professor professor) {
		this.id = professor.getId();
		this.nome = professor.getNome();
		this.telefone = professor.getTelefone();
		this.valorHoraAula = professor.getValorHoraAula();
	}

}