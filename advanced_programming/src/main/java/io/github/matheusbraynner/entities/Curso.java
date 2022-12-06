package io.github.matheusbraynner.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@ElementCollection
	private List<LocalDate> segunda = new ArrayList<>();
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@ElementCollection
	private List<LocalDate> terca = new ArrayList<>();
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@ElementCollection
	private List<LocalDate> quarta = new ArrayList<>();
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@ElementCollection
	private List<LocalDate> quinta = new ArrayList<>();
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@ElementCollection
	private List<LocalDate> sexta = new ArrayList<>();
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@ElementCollection
	private List<LocalDate> sabado = new ArrayList<>();
	@Enumerated(EnumType.STRING)
	private Turno turno;
	private Double valor;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCurso", fetch = FetchType.LAZY)
	private List<DiaAula> diasAulas = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cursoId", fetch = FetchType.LAZY)
	private List<Turma> Turmas = new ArrayList<>();
}
