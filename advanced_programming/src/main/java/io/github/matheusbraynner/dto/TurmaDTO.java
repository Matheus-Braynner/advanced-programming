package io.github.matheusbraynner.dto;

import java.io.Serializable;
import java.util.List;

import io.github.matheusbraynner.entities.Aluno;
import io.github.matheusbraynner.entities.Curso;
import io.github.matheusbraynner.entities.Professor;
import io.github.matheusbraynner.entities.Turma;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TurmaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Double valor;
	private List<Aluno> alunos;
	private Curso curso;
	private Professor professor;
	
	public TurmaDTO (Turma turma) {
		this.id = turma.getId();
		this.valor = turma.getValor();
		this.alunos = turma.getAlunos();
		this.curso = turma.getCursoId();
		this.professor = turma.getProfessorId();
	}
}
