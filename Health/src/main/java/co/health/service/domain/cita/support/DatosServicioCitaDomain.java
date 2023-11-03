package co.health.service.domain.cita.support;

import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilTexto;

public class DatosServicioCitaDomain {
	
	private String codigo;
	private String consultorio;
	private String nombreServicio;
	private long precio;
	
	public  DatosServicioCitaDomain() {
		setConsultorio(UtilTexto.VACIO);
		setPrecio(0);
		setNombreServicio(UtilTexto.VACIO);
		setCodigo(UtilTexto.VACIO);
	}
	
	private DatosServicioCitaDomain(final String codigo, final String consultorio, final String nombreServicio,
		final long precio) {
		setConsultorio(consultorio);
		setPrecio(precio);
		setNombreServicio(nombreServicio);
		setCodigo(codigo);
	}
	
	public static final DatosServicioCitaDomain crear(final String codigo,final String consultorio, final String nombreServicio, 
			final long precio) {
		return new DatosServicioCitaDomain(codigo,consultorio, nombreServicio, precio);
	}
	
	public static final DatosServicioCitaDomain crear(){
		return new DatosServicioCitaDomain();
	}

	public final String getConsultorio() {
		return consultorio;
	}

	public final String getNombreServicio() {
		return nombreServicio;
	}

	public final long getPrecio() {
		return precio;
	}
	
	public final String getCodigo() {
		return codigo;
	}

	private final void setConsultorio(final String consultorio) {
		this.consultorio = UtilObjeto.obtenerValorDefecto(consultorio, UtilTexto.VACIO);
	}

	private final void setNombreServicio(final String nombreServicio) {
		this.nombreServicio = UtilObjeto.obtenerValorDefecto(nombreServicio, UtilTexto.VACIO);
	}

	private final void setPrecio(final long precio) {
		this.precio = (long) UtilObjeto.obtenerValorDefecto(precio,0);
	}

	private final void setCodigo(final String codigo) {
		this.codigo = UtilObjeto.obtenerValorDefecto(codigo, UtilTexto.VACIO);;
	}
}
