package co.health.service.domain.cita.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilLong;
import co.health.service.domain.ValidationRule;

public class PrecioCitaValidationRule implements ValidationRule<Long>{
	private static final ValidationRule<Long> instancia = new PrecioCitaValidationRule();

	private PrecioCitaValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final Long dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(Long dato) {
		validarObligatoriedad(dato);
		
	}
	
	
	public void validarObligatoriedad(Long dato) {
		if(UtilLong.esNulo(dato)) {
			var mensajeUsuario = "La fecha de la cita es un dato Obligatorio";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
		
	}

	
	

}
