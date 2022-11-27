package io.github.matheusbraynner.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.matheusbraynner.entities.Feriado;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeriadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idFeriado;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataFeriado;
	private String descricao;

	public FeriadoDTO (Feriado feriado) {
		this.idFeriado = feriado.getIdFeriado();
		this.dataFeriado = feriado.getDataFeriado();
		this.descricao = feriado.getDescricao();
	}
}
