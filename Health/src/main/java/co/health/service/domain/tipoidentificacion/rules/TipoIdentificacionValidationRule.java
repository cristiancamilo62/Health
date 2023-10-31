package co.health.service.domain.tipoidentificacion.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.ValidationRule;
import co.health.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public final class TipoIdentificacionValidationRule implements ValidationRule<TipoIdentificacionDomain>{
	
private static final ValidationRule<TipoIdentificacionDomain> instancia = new TipoIdentificacionValidationRule();
	
	private TipoIdentificacionValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final TipoIdentificacionDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final TipoIdentificacionDomain dato) {
		System.out.println(dato.getCodigo());
		if(UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = "No es posible realizar la operacion con un tipo de identificación nulo";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
}

}
