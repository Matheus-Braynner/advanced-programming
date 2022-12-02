package io.github.matheusbraynner.dto;

import java.io.Serializable;

import io.github.matheusbraynner.entities.Aluno;
import io.github.matheusbraynner.entities.Turma;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String telefone;
	private String endereco;
	private Turma turma;
	
	public AlunoDTO (Aluno aluno) {
		this.id = aluno.getId();
		this.nome = aluno.getNome();
		this.telefone = aluno.getTelefone();
		this.endereco = aluno.getEndereco();
		this.turma = aluno.getTurmaId();
	}
}
