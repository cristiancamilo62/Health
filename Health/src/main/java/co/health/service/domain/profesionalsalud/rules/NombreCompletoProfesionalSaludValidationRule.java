package co.health.service.domain.profesionalsalud.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;
import co.health.service.domain.paciente.support.NombreCompletoDomain;

public class NombreCompletoProfesionalSaludValidationRule implements ValidationRule<NombreCompletoDomain> {
private static final ValidationRule<NombreCompletoDomain> instancia = new NombreCompletoProfesionalSaludValidationRule();
	
	public NombreCompletoProfesionalSaludValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final NombreCompletoDomain dato) {
		instancia.validar(dato);
	}
	

	@Override
	public final void validar(final NombreCompletoDomain dato) {
		validarObligatoriedad(dato);
		validarLongitud(dato);
		validarFormato(dato);
	}

	
	public final void validarLongitud(final NombreCompletoDomain dato) {
		validarLongitudPrimerNombre(dato);
		validarLongitudSegundoNombre(dato);
		validarLongitudPrimerApellido(dato);
		validadLongitudSegundoApellido(dato);
		
	}
	private final void validarLongitudPrimerNombre(final NombreCompletoDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getPrimerNombre(),10)) {
			var mensajeUsuario = "La maxima del primer nombre es de 10 caracteres";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}

	private final void validarLongitudSegundoNombre(final NombreCompletoDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getSegundoNombre(),10)) {
			var mensajeUsuario = "La maxima del segundo nombre es de 10 caracteres";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}

	private final void validarLongitudPrimerApellido(final NombreCompletoDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getPrimerApellido(),10)) {
			var mensajeUsuario = "La maxima del primer apellido es de 10 caracteres";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
		
	}

	private final void validadLongitudSegundoApellido(final NombreCompletoDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getSegundoApellido(),10)) {
			var mensajeUsuario = "La maxima del segundo apellido es de 10 caracteres";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
		
	
	private final void validarFormato(final NombreCompletoDomain dato) {
		validarFormatoPrimerNombre(dato);
		validarFormatoSegundoNombre(dato);
		validarFormatoPrimerApellido(dato);
		validarFormatoSegundoApellido(dato);
	}

	private final void validarFormatoPrimerNombre(final NombreCompletoDomain dato) {
		if(!UtilTexto.contieneSoloLetrasDigitos(dato.getPrimerNombre())) {
			var mensajeUsuario = "El primer nombre debe tener solo letras o digitos";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
		
	}

	private final void validarFormatoSegundoNombre(final NombreCompletoDomain dato) {
		if(UtilTexto.contieneSoloLetrasDigitos(dato.getSegundoNombre())) {
			var mensajeUsuario = "El segundo nombre debe tener solo letras o digitos" ;
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}

	private final void validarFormatoPrimerApellido(final NombreCompletoDomain dato) {
		if(!UtilTexto.contieneSoloLetrasDigitos(dato.getPrimerApellido())) {
			var mensajeUsuario = "El primer apellido debe tener solo letras o digitos"  ;
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}

	private final void validarFormatoSegundoApellido(final NombreCompletoDomain dato) {
		if(!UtilTexto.contieneSoloLetrasDigitos(dato.getSegundoApellido()) || !UtilTexto.estaVacio(dato.getSegundoApellido())) {
			var mensajeUsuario = "El segundo apellido debe tener solo letras o digitos"  ;
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}

	private final void validarObligatoriedad(final NombreCompletoDomain dato) {
		validarObligatoriedadPrimerNombre(dato);
		validarObligatoriedadPrimerApellido(dato);
		
	}

	private final void validarObligatoriedadPrimerNombre(final NombreCompletoDomain dato) {
		if(UtilTexto.estaVacio(dato.getPrimerNombre())) {
			var mensajeUsuario = "El primer nombre es un dato Obligatorio";
			ServiceHealthException.crear(mensajeUsuario);
		}
		
	}

	private final void validarObligatoriedadPrimerApellido(final NombreCompletoDomain dato) {
		if(UtilTexto.estaVacio(dato.getPrimerApellido())) {
			var mensajeUsuario = "El primer apellido es un dato Obligatorio" ;
			ServiceHealthException.crear(mensajeUsuario);
		}
	}

}
