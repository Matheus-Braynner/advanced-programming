package io.github.matheusbraynner.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.matheusbraynner.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Lead implements Serializable {
 static final long serialVersionUID = 1L;
 	
 	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	@EqualsAndHashCode.Include
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

}
