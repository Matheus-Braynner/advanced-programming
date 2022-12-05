package io.github.matheusbraynner.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.github.matheusbraynner.entities.enums.Turno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private String nomeCurso;
	private Double cargaHorariaAula;
	private Double cargaHorariaTotal;
	@Enumerated(EnumType.STRING)
	private Turno turno;
	private Double valor;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCurso", fetch = FetchType.LAZY)
	private List<DiaAula> diasAulas = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cursoId", fetch = FetchType.LAZY)
	private List<Turma> Turmas = new ArrayList<>();
}
