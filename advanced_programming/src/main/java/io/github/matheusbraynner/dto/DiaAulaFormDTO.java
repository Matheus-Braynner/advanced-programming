package io.github.matheusbraynner.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiaAulaFormDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotNull(message = "obligatory field")
	private Long idCurso;
	@NotNull(message = "obligatory field")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date diaAula;
}
