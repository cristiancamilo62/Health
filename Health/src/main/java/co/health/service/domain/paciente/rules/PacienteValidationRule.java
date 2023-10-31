package co.health.service.domain.paciente.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.ValidationRule;
import co.health.service.domain.paciente.PacienteDomain;

public final class PacienteValidationRule implements ValidationRule<PacienteDomain>{

private static final ValidationRule<PacienteDomain> instancia = new PacienteValidationRule();
	
	private  PacienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final PacienteDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final PacienteDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			//TODO MENsajes
			var mensajeUsuario = "No es posible realizar la operacion con un cliente Nulo";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
		
	}
}
