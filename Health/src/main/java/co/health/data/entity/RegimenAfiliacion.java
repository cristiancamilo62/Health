package co.health.data.entity;

import java.util.UUID;

public class RegimenAfiliacion {

	private UUID id;
	private String tipo;
	private String coberturaServicios;
	
	private RegimenAfiliacion(final UUID id, final String tipo, final String coberturaServicios) {
		setId(id);
		setTipo(tipo);
		setCoberturaServicios(coberturaServicios);
	}
	
	public static final RegimenAfiliacion crear(final UUID id, final String tipo, final String coberturaServicios) {
		return new RegimenAfiliacion(id, tipo, coberturaServicios);
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setTipo(final String tipo) {
		this.tipo = tipo;
	}

	private final void setCoberturaServicios(final String coberturaServicios) {
		this.coberturaServicios = coberturaServicios;
	}

	public final UUID getId() {
		return id;
	}

	public final String getTipo() {
		return tipo;
	}

	public final String getCoberturaServicios() {
		return coberturaServicios;
	}
}
