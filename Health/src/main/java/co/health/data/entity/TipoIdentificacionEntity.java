package co.health.data.entity;

import java.util.UUID;

public class TipoIdentificacionEntity {
	
	private UUID id;
	private String nombre;
	private String codigo;
	
	private TipoIdentificacionEntity(final UUID id, final String nombre, final String codigo) {
		setId(id);
		setNombre(nombre);
		setCodigo(codigo);
	}

	public static final TipoIdentificacionEntity crear(final UUID id, final String nombre, final String codigo) {
		return new TipoIdentificacionEntity(id, nombre, codigo);
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	private final void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}

	public final String getCodigo() {
		return codigo;
	}
	
	
	
	
}
