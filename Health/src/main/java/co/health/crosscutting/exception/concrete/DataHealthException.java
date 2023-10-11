package co.health.crosscutting.exception.concrete;

import co.health.crosscutting.exception.HealthException;
import co.health.crosscutting.exception.enumerator.lugarExcepcion;

public class DataHealthException extends HealthException {
	
	private static final long serialVersionUID = -9177484194126685659L;
	
	protected DataHealthException(final Throwable exceptionRaiz,final String mensajeUsuario,
			final String mensajeTecnico) {
		super(lugarExcepcion.DATA, exceptionRaiz, mensajeUsuario, 
				mensajeTecnico);
	}

	
	public static final HealthException crear(final String mensajeUsuario) {
		return new DataHealthException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final HealthException crear(final String mensajeUsuario,final String mensajeTecnico) {
		return new DataHealthException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final HealthException crear(final String mensajeUsuario,final String mensajeTecnico,
			final Throwable exceptionRaiz ) {
		return new DataHealthException(exceptionRaiz, mensajeUsuario, mensajeTecnico);
	}

}
