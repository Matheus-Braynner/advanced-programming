package io.github.matheusbraynner.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.matheusbraynner.entities.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LeadFormDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank(message = "Campo obrigatório")
 	private String nome;
	@NotBlank(message = "Campo obrigatório")
 	private String telefone;
	@NotNull(message = "obligatory field")
 	private Status status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
 	private Date dataCadastro;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
 	private Date dataNovoContato;
 	@NotBlank(message = "Campo obrigatório")
 	private String observacao;
}


