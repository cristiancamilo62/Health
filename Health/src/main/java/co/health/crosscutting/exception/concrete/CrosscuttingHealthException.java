package co.health.crosscutting.exception.concrete;

import co.health.crosscutting.exception.HealthException;
import co.health.crosscutting.exception.enumerator.lugarExcepcion;

public class CrosscuttingHealthException extends HealthException{
	
	private static final long serialVersionUID = 1L;

	protected CrosscuttingHealthException(final Throwable exceptionRaiz,final String mensajeUsuario,
			final String mensajeTecnico) {
		super(lugarExcepcion.CROSSCUTTING, exceptionRaiz, mensajeUsuario, mensajeTecnico);
	}

	public static final HealthException crear(final String mensajeUsuario) {
		return new CrosscuttingHealthException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final HealthException crear(final String mensajeUsuario,final String mensajeTecnico) {
		return new CrosscuttingHealthException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final HealthException crear(final String mensajeUsuario,final String mensajeTecnico,
			final Throwable exceptionRaiz ) {
		return new CrosscuttingHealthException(exceptionRaiz, mensajeUsuario, mensajeTecnico);
	}
}