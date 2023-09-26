package co.health.data.entity;

import java.util.UUID;

public class Paciente {
	
	private UUID id;
	private String numeroIdentificacion;
	private String nombre;
	private String apellido;
	private String correoElectronico;
	private boolean correoELectronicoConfirmado;
	private String numeroTelefono;
	private boolean numeroTelefonoConfirmado;
	private boolean estadoCuenta;
	private TipoIdentificacion tipoIdentificacion;
	
	
	private Paciente(final UUID id, final String numeroIdentificacion, final String nombre, final String apellido, final String correoElectronico,
			final String numeroTelefono, final TipoIdentificacion tipoIdentificacion) {
		setId(id);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombre(nombre);
		setApellido(apellido);
		setCorreoElectronico(correoElectronico);
		setNumeroTelefono(numeroTelefono);
		setTipoIdentificacion(tipoIdentificacion);
	}
	
	public static final Paciente crear(final UUID id, final String numeroIdentificacion, final String nombre, final String apellido, final String correoElectronico,
			final String numeroTelefono, final TipoIdentificacion tipoIdentificacion) {
		return new Paciente(id, numeroIdentificacion, nombre, apellido, correoElectronico, numeroTelefono, tipoIdentificacion);
	}


	private final void setId(final UUID id) {
		this.id = id;
	}


	private final void setNumeroIdentificacion(final String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}


	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}


	private final void setApellido(final String apellido) {
		this.apellido = apellido;
	}


	private final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	private final void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	private final void setTipoIdentificacion(final TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public final UUID getId() {
		return id;
	}

	public final String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public final String getNombre() {
		return nombre;
	}

	public final String getApellido() {
		return apellido;
	}

	public final String getCorreoElectronico() {
		return correoElectronico;
	}

	public final boolean isCorreoELectronicoConfirmado() {
		return correoELectronicoConfirmado;
	}

	public final String getNumeroTelefono() {
		return numeroTelefono;
	}

	public final boolean isNumeroTelefonoConfirmado() {
		return numeroTelefonoConfirmado;
	}

	public final boolean isEstadoCuenta() {
		return estadoCuenta;
	}

	public final TipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	
	
	

}
