package co.health.data.entity;

import java.util.UUID;

public class Eps {
	
	private UUID id;
	private String nombre;
	
	private Eps(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final Eps crear(final UUID id, final String nombre) {
		return new Eps(id, nombre);
	}

	private final void setId(UUID id) {
		this.id = id;
	}

	private final void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}
	
	
}
