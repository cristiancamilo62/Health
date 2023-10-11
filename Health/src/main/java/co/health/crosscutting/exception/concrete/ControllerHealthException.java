package co.health.crosscutting.exception.concrete;

import co.health.crosscutting.exception.HealthException;
import co.health.crosscutting.exception.enumerator.lugarExcepcion;

public class ControllerHealthException extends HealthException{

	private static final long serialVersionUID = -8188542974233092305L;
	
	protected ControllerHealthException(final Throwable exceptionRaiz,final String mensajeUsuario,
			final String mensajeTecnico) {
		super(lugarExcepcion.CONTROLLER, exceptionRaiz, mensajeUsuario, mensajeTecnico);
	}

	public static final HealthException crear(final String mensajeUsuario) {
		return new ControllerHealthException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final HealthException crear(final String mensajeUsuario,final String mensajeTecnico) {
		return new ControllerHealthException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final HealthException crear(final String mensajeUsuario,final String mensajeTecnico,
			final Throwable exceptionRaiz ) {
		return new ControllerHealthException(exceptionRaiz, mensajeUsuario, mensajeTecnico);
	}
}
