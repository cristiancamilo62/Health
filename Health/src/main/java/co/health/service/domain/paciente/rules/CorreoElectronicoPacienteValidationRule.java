package co.health.service.domain.paciente.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;
import co.health.service.domain.paciente.support.CorreoElectronicoPacienteDomain;

public final class CorreoElectronicoPacienteValidationRule implements ValidationRule<CorreoElectronicoPacienteDomain>{
	
private static final ValidationRule<CorreoElectronicoPacienteDomain> instancia = new CorreoElectronicoPacienteValidationRule();
	
	private   CorreoElectronicoPacienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final CorreoElectronicoPacienteDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final CorreoElectronicoPacienteDomain dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
	}
	
	private final void validarLongitud(final CorreoElectronicoPacienteDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getCorreoElectronico(), 40)) {
			var mensajeUsuario = "La longitud maxima del correo electronico es de 40";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoriedad(final CorreoElectronicoPacienteDomain dato) {
		if(UtilTexto.estaVacio(dato.getCorreoElectronico())) {
			var mensajeUsuario = "El correo electronico es una dato obligatorio";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
	
	private final void validarFormato(final CorreoElectronicoPacienteDomain dato) {
		if(!UtilTexto.contieneSoloLetrasDigitosArrobaDominio(dato.getCorreoElectronico())) {
			var mensajeUsuario = "El correo electronico ingresado no es un dato valido. verifique su formato a 'ejemplo12@gmail.com'";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
		
	}


}
