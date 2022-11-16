package io.github.matheusbraynner.dto;

import java.io.Serializable;

import io.github.matheusbraynner.entities.Aluno;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String telefone;
	private String endereco;
	
	public AlunoDTO (Aluno aluno) {
		this.id = aluno.getId();
		this.nome = aluno.getNome();
		this.telefone = aluno.getTelefone();
		this.endereco = aluno.getEndereco();
	}
}
