package co.health.data.entity;

import java.util.UUID;

public class EstadoCita {
	
	private UUID id;
	private String nombre;
	
	private EstadoCita(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final EstadoCita crear(final UUID id, final String nombre) {
		return new EstadoCita(id, nombre);
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}
	

}
