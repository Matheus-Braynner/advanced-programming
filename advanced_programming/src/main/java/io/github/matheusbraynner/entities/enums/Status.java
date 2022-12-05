package io.github.matheusbraynner.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
	
	AVALIANDO("avaliando"),
	INTERESSADO("Interessado"),
	PENSANDO_COMPRAR("Pensando em comprar"),
	SEM_INTERESSE("Sem interesse"),
	LIGAR_DEPOIS("Ligar depois");
	
private String status;
	
	public static Status toEnum(String cod) {
        if (cod == null) {
            return null;
        }

        for (Status x : Status.values()) {
            if (cod.equals(x.getStatus())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Political Office invalid: " + cod + ".");
    }
	
}
