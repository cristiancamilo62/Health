package co.health.service.domain.paciente.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;

public final class NumeroIdentificacionPacienteValidationRule implements ValidationRule<String> {
	
private static final ValidationRule<String> instancia = new NumeroIdentificacionPacienteValidationRule();
	
	private NumeroIdentificacionPacienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(String dato) {
		validarObligatoriedad(dato);
		validarFormato(dato);
		validarLongitud(dato);
		
	}
	
	private final void validarLongitud(final String dato) {
		if(!UtilTexto.longitudIgual(dato,10)) {
			var mensajeUsuario = "la longitud del numero de identificacion debe ser igual a 10";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			var mensajeUsuario = "EL número de identificacion es un dato obligatorio";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
		
		
	}
	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloDigitos(dato)) {
			var mensajeUsuario = "El número de identificacion debe tener solo números";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
		
		
	}

}
