package co.health.service.dto;

import java.util.UUID;

import co.health.crosscutting.util.UtilTexto;

public class TipoIdentificacionDTO {

	private UUID id;
	private String codigo;
	private String nombre;
	
	public TipoIdentificacionDTO() {
		setId(id);//TODO : ¿cómo lograr que por defecto se asine un UUID que sea todo con 0?
		setCodigo(UtilTexto.VACIO);
		setNombre(UtilTexto.VACIO);
	}
	
	public TipoIdentificacionDTO(final UUID id, final String codigo, final String nombre) {
		setId(id);
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public static final TipoIdentificacionDTO crear() {
		return new TipoIdentificacionDTO();
	}
	
	public final UUID getId() {
		return id;
	}
	public final TipoIdentificacionDTO setId(final UUID id) {
		this.id = id;
		return this;
	}
	public final String getCodigo() {
		return codigo;
	}
	public final TipoIdentificacionDTO setCodigo(final String codigo) {
		this.codigo = codigo;
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final TipoIdentificacionDTO setNombre(final String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	
}
