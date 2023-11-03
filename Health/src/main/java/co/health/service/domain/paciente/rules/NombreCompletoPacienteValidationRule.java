package co.health.service.domain.paciente.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;
import co.health.service.domain.paciente.support.NombreCompletoPacienteDomain;

public final class NombreCompletoPacienteValidationRule implements ValidationRule<NombreCompletoPacienteDomain>{
	
private static final ValidationRule<NombreCompletoPacienteDomain> instancia = new NombreCompletoPacienteValidationRule();
	
	public NombreCompletoPacienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final NombreCompletoPacienteDomain dato) {
		instancia.validar(dato);
	}
	

	@Override
	public final void validar(final NombreCompletoPacienteDomain dato) {
		validarObligatoriedad(dato);
		validarLongitud(dato);
		validarFormato(dato);
	}

	
	public final void validarLongitud(final NombreCompletoPacienteDomain dato) {
		validarLongitudPrimerNombre(dato);
		validarLongitudSegundoNombre(dato);
		validarLongitudPrimerApellido(dato);
		validadLongitudSegundoApellido(dato);
		
	}
	private final void validarLongitudPrimerNombre(final NombreCompletoPacienteDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getPrimerNombre(),10)) {
			var mensajeUsuario = "La maxima del primer nombre es de 10 caracteres";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}

	private final void validarLongitudSegundoNombre(final NombreCompletoPacienteDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getSegundoNombre(),10)) {
			var mensajeUsuario = "La maxima del segundo nombre es de 10 caracteres";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}

	private final void validarLongitudPrimerApellido(final NombreCompletoPacienteDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getPrimerApellido(),10)) {
			var mensajeUsuario = "La maxima del primer apellido es de 10 caracteres";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
		
	}

	private final void validadLongitudSegundoApellido(final NombreCompletoPacienteDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getSegundoApellido(),10)) {
			var mensajeUsuario = "La maxima del segundo apellido es de 10 caracteres";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
		
	
	private final void validarFormato(final NombreCompletoPacienteDomain dato) {
		validarFormatoPrimerNombre(dato);
		validarFormatoSegundoNombre(dato);
		validarFormatoPrimerApellido(dato);
		validarFormatoSegundoApellido(dato);
	}

	private final void validarFormatoPrimerNombre(final NombreCompletoPacienteDomain dato) {
		if(!UtilTexto.contieneSoloLetrasDigitos(dato.getPrimerNombre())) {
			var mensajeUsuario = "El primer nombre debe tener solo letras o digitos";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
		
	}

	private final void validarFormatoSegundoNombre(final NombreCompletoPacienteDomain dato) {
		if(!UtilTexto.contieneSoloLetrasDigitos(dato.getSegundoNombre())) {
			var mensajeUsuario = "El segundo nombre debe tener solo letras o digitos" ;
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}

	private final void validarFormatoPrimerApellido(final NombreCompletoPacienteDomain dato) {
		if(!UtilTexto.contieneSoloLetrasDigitos(dato.getPrimerApellido())) {
			var mensajeUsuario = "El primer apellido debe tener solo letras o digitos"  ;
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}

	private final void validarFormatoSegundoApellido(final NombreCompletoPacienteDomain dato) {
		if(!UtilTexto.contieneSoloLetrasDigitos(dato.getSegundoApellido())) {
			var mensajeUsuario = "El segundo apellido debe tener solo letras o digitos"  ;
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}

	private final void validarObligatoriedad(final NombreCompletoPacienteDomain dato) {
		validarObligatoriedadPrimerNombre(dato);
		validarObligatoriedadPrimerApellido(dato);
		
	}

	private final void validarObligatoriedadPrimerNombre(final NombreCompletoPacienteDomain dato) {
		if(UtilTexto.estaVacio(dato.getPrimerNombre())) {
			var mensajeUsuario = "El primer nombre es un dato Obligatorio";
			ServiceHealthException.crear(mensajeUsuario);
		}
		
	}

	private final void validarObligatoriedadPrimerApellido(final NombreCompletoPacienteDomain dato) {
		if(UtilTexto.estaVacio(dato.getPrimerApellido())) {
			var mensajeUsuario = "El primer apellido es un dato Obligatorio" ;
			ServiceHealthException.crear(mensajeUsuario);
		}
	}

}
