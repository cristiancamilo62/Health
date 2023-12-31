package co.health.service.domain.cita.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;

public class ConsultorioCitaValidationRule implements ValidationRule<String>{
private static final ValidationRule<String> instancia = new ConsultorioCitaValidationRule();
	
	private ConsultorioCitaValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(String dato) {
		validarObligatoriedad(dato);
		validarLongitud(dato);
		validarFormato(dato);
		
	}
	
	private final void validarLongitud(final String dato) {
		if(!UtilTexto.longitudMaximaValida(dato,30)) {
			var mensajeUsuario = "la longitud del nombre del consultorio de la cita debe ser menor a 30";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			var mensajeUsuario = "El nombre del consultorio de la cita es un dato obligatorio";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
	
	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloLetrasDigitos(dato)) {
			var mensajeUsuario = "El nombre del consultorio de la cita debe tener solo letras y digitos";
			throw ServiceHealthException.crear(mensajeUsuario);
		}	
	}
}
