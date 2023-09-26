package co.health.data.entity;

import java.util.UUID;
import java.util.Date;

public class Factura {
	
	private UUID id;
	private String codigo;
	private Date fecha;
	private float montoTotal;
	private String descripcion;
	
	private Factura(final UUID id, final String codigo, final Date fecha, final float montoTotal, final String descripcion) {
		setId(id);
		setCodigo(codigo);
		setFecha(fecha);
		setMontoTotal(montoTotal);
		setDescripcion(descripcion);
	}
	
	public static final Factura crear(final UUID id, final String codigo, final Date fecha, final float montoTotal, final String descripcion) {
		return new Factura(id, codigo, fecha, montoTotal, descripcion);
	}
	
	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	private final void setFecha(final Date fecha) {
		this.fecha = fecha;
	}

	private final void setMontoTotal(final float montoTotal) {
		this.montoTotal = montoTotal;
	}

	private final void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	public final UUID getId() {
		return id;
	}

	public final String getCodigo() {
		return codigo;
	}

	public final Date getFecha() {
		return fecha;
	}

	public final float getMontoTotal() {
		return montoTotal;
	}

	public final String getDescripcion() {
		return descripcion;
	}
	
	
}
