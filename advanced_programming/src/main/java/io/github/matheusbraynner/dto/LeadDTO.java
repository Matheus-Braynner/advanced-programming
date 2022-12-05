package io.github.matheusbraynner.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.matheusbraynner.entities.Lead;
import io.github.matheusbraynner.entities.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LeadDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
 	private String nome;
 	private String telefone;
 	@Enumerated(EnumType.STRING)
 	private Status status;
 	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
 	private Date dataCadastro;
 	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
 	private Date dataNovoContato;
 	private String observacao;
	
	public LeadDTO (Lead lead) {
		this.id = lead.getId();
		this.nome = lead.getNome();
		this.telefone = lead.getTelefone();
		this.status = lead.getStatus();
		this.dataCadastro = lead.getDataCadastro();
		this.dataNovoContato = lead.getDataNovoContato();
		this.observacao = lead.getObservacao();
	}
}
