package co.health.data.entity;

import java.util.UUID;
import java.util.Date;

public class Cita {
	
	private UUID id;
	private String codigo;
	private int consultorio;
	private String nombreServicio;
	private String nombreProfesionalSalud;
	private Date fechaInicio;
	private Date fechaFin;
	
	private Cita(final UUID id, final String codigo, final int consultorio, final String nombreServicio, final String nombreProfesionalSalud,
			final Date fechaInicio, final Date fechaFin) {
		setId(id);
		setCodigo(codigo);
		setConsultorio(consultorio);
		setNombreServicio(nombreServicio);
		setNombreProfesionalSalud(nombreProfesionalSalud);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
	}
	
	public static final Cita crear(final UUID id, final String codigo, final int consultorio, final String nombreServicio, final String nombreProfesionalSalud,
			final Date fechaInicio, final Date fechaFin) {
		return new Cita(id, codigo, consultorio, nombreServicio, nombreProfesionalSalud, fechaInicio, fechaFin);
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	private final void setConsultorio(final int consultorio) {
		this.consultorio = consultorio;
	}

	private final void setNombreServicio(final String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	private final void setNombreProfesionalSalud(final String nombreProfesionalSalud) {
		this.nombreProfesionalSalud = nombreProfesionalSalud;
	}

	private final void setFechaInicio(final Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	private final void setFechaFin(final Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public final UUID getId() {
		return id;
	}

	public final String getCodigo() {
		return codigo;
	}

	public final int getConsultorio() {
		return consultorio;
	}

	public final String getNombreServicio() {
		return nombreServicio;
	}

	public final String getNombreProfesionalSalud() {
		return nombreProfesionalSalud;
	}

	public final Date getFechaInicio() {
		return fechaInicio;
	}

	public final Date getFechaFin() {
		return fechaFin;
	}
	
	
	

}
