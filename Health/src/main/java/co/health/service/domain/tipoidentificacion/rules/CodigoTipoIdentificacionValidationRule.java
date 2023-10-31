package co.health.service.domain.tipoidentificacion.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;

public final class CodigoTipoIdentificacionValidationRule implements ValidationRule<String>{
	
	private static final ValidationRule<String> instancia = new CodigoTipoIdentificacionValidationRule();
	
	private CodigoTipoIdentificacionValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(String dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
		
	}
	
	private final void validarLongitud(final String dato) {
		if(!UtilTexto.longitudMaximaValida(dato,50)) {
			var mensajeUsuario = "La longitud del codigo del tipo de identificacion no en valida.La longitud maxima es 50 caracteres";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			var mensajeUsuario = "El código del tipo de identificacion es oblgatorio";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
		
		
	}
	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloLetras(dato)) {
			var mensajeUsuario = "El código del tipo de identificación solo debe contener letras";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
		
		
	}

}
