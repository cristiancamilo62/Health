package co.health.crosscutting.exception.concrete;

import co.health.crosscutting.exception.HealthException;
import co.health.crosscutting.exception.enumerator.lugarExcepcion;

public class ServiceHealthException extends HealthException {
	
	private static final long serialVersionUID = -9177484194126685659L;
	
	protected ServiceHealthException(final Throwable exceptionRaiz,final String mensajeUsuario,
			final String mensajeTecnico) {
		super(lugarExcepcion.SERVICE, exceptionRaiz, mensajeUsuario, mensajeTecnico);
	}

	
	public static final HealthException crear(final String mensajeUsuario) {
		return new ServiceHealthException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final HealthException crear(final String mensajeUsuario,final String mensajeTecnico) {
		return new ServiceHealthException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final HealthException crear(final String mensajeUsuario,final String mensajeTecnico,
			final Throwable exceptionRaiz ) {
		return new ServiceHealthException(exceptionRaiz, mensajeUsuario, mensajeTecnico);
	}

}
