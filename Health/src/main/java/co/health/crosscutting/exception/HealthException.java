package co.health.crosscutting.exception;

import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilTexto;
import co.health.crosscutting.exception.enumerator.lugarExcepcion;

public class HealthException extends RuntimeException {
	
	
	private static final long serialVersionUID = -551425372694998396L;
	private lugarExcepcion lugar;
	private Throwable exceptionRaiz;
	private String mensajeUsuario;
	private String mensajeTecnico;
	private boolean tieneExcepcionRaiz;
	
	protected HealthException(final lugarExcepcion lugar,final Throwable exceptionRaiz,final String mensajeUsuario,final
			String mensajeTecnico) {
		setLugar(lugar);
		setExceptionRaiz(exceptionRaiz);
		setMensajeUsuario(mensajeUsuario);
		setMensajeTecnico(mensajeTecnico);
	}

	private final void setLugar(final lugarExcepcion lugar) {
		this.lugar = UtilObjeto.obtenerValorDefecto(lugar, lugarExcepcion.GENERAL);
	}
	
	private final void setExceptionRaiz(final Throwable exceptionRaiz) {
		setTieneExcepcionRaiz(!(UtilObjeto.esNulo(exceptionRaiz)));
		this.exceptionRaiz = UtilObjeto.obtenerValorDefecto(exceptionRaiz, new Exception());
	}
	
	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = UtilTexto.aplicarTrim(mensajeUsuario);
	}
	
	private final void setMensajeTecnico(final String mensajeTecnico) {
		this.mensajeTecnico = UtilTexto.aplicarTrim(mensajeTecnico);
	}
	
	
	private final void setTieneExcepcionRaiz(boolean tieneExcepcionRaiz) {
		this.tieneExcepcionRaiz = tieneExcepcionRaiz;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public lugarExcepcion getLugar() {
		return lugar;
	}
	
	public Throwable getExceptionRaiz() {
		return exceptionRaiz;
	}
	
	public String getMensajeUsuario() {
		return mensajeUsuario;
	}
	
	public String getMensajeTecnico() {
		return mensajeTecnico;
	}

	public final boolean isTieneExcepcionRaiz() {
		return tieneExcepcionRaiz;
	}
	

}
