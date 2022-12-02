package io.github.matheusbraynner.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "turmaId", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Aluno> alunos = new ArrayList<>();
	private Double valor;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private Curso cursoId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private Professor professorId;

}