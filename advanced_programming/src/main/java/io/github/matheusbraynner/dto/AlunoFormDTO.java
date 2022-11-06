package io.github.matheusbraynner.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlunoFormDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotBlank(message = "Campo obrigatório")
	private String nome;
	@NotBlank(message = "Campo obrigatório")
	private String telefone;
	@NotBlank(message = "Campo obrigatório")
	private String endereco;
	@NotBlank(message = "Campo obrigatório")
	private String cpf;
}
