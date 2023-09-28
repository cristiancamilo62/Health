package co.health.data.entity;

import java.sql.Date;
import java.util.UUID;

import co.health.data.entity.support.CorreoElectronicoPacienteEntity;
import co.health.data.entity.support.NombreCompletoPacienteEntity;
import co.health.data.entity.support.NumeroTelefonoPacienteEntity;

public class PacienteEntity {
	
	private UUID id;
	private String numeroIdentificacion;
	private NombreCompletoPacienteEntity nombreCompletoPaciente;
	private CorreoElectronicoPacienteEntity correoElectronicoPaciente;
	private NumeroTelefonoPacienteEntity numeroTelefonoPaciente;
	private boolean estadoCuenta;
	private Date fechaNacimiento;
	private TipoIdentificacionEntity tipoIdentificacion;
	private RegimenAfiliacion regimenAfiliacion;
	private String direccionResidencia;
	private Eps eps;
	
	
	
	
	private PacienteEntity(final UUID id, final String numeroIdentificacion, final NombreCompletoPacienteEntity nombreCompletoPaciente,
			final CorreoElectronicoPacienteEntity correoElectronicoPaciente,
			final NumeroTelefonoPacienteEntity numeroTelefonoPaciente, final boolean estadoCuenta, final Date fechaNacimiento,
			final TipoIdentificacionEntity tipoIdentificacion, final RegimenAfiliacion regimenAfiliacion,
			final String direccionResidencia, final Eps eps) {
		setId(id);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombreCompletoPaciente(nombreCompletoPaciente);
		setCorreoElectronicoPaciente(correoElectronicoPaciente);
		setNumeroTelefonoPaciente(numeroTelefonoPaciente);
		setEstadoCuenta(estadoCuenta);
		setFechaNacimiento(fechaNacimiento);
		setTipoIdentificacion(tipoIdentificacion);
		setRegimenAfiliacion(regimenAfiliacion);
		setDireccionResidencia(direccionResidencia);
		setEps(eps);
	}

	public static final PacienteEntity crear(final UUID id, final String numeroIdentificacion, final NombreCompletoPacienteEntity nombreCompletoPaciente,
			final CorreoElectronicoPacienteEntity correoElectronicoPaciente,
			final NumeroTelefonoPacienteEntity numeroTelefonoPaciente, final boolean estadoCuenta, final Date fechaNacimiento,
			final TipoIdentificacionEntity tipoIdentificacion, final RegimenAfiliacion regimenAfiliacion,
			final String direccionResidencia, final Eps eps) {
		return new PacienteEntity(id, numeroIdentificacion, nombreCompletoPaciente, correoElectronicoPaciente,
				numeroTelefonoPaciente, estadoCuenta,fechaNacimiento, tipoIdentificacion, regimenAfiliacion, 
				direccionResidencia, eps);
	}

	public final UUID getId() {
		return id;
	}

	public final String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public final NombreCompletoPacienteEntity getNombreCompletoPaciente() {
		return nombreCompletoPaciente;
	}

	public final CorreoElectronicoPacienteEntity getCorreoElectronicoPaciente() {
		return correoElectronicoPaciente;
	}

	public final NumeroTelefonoPacienteEntity getNumeroTelefonoPaciente() {
		return numeroTelefonoPaciente;
	}

	public final boolean isEstadoCuenta() {
		return estadoCuenta;
	}

	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public final TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public final RegimenAfiliacion getRegimenAfiliacion() {
		return regimenAfiliacion;
	}

	public final String getDireccionResidencia() {
		return direccionResidencia;
	}

	public final Eps getEps() {
		return eps;
	}

	private final void setId(UUID id) {
		this.id = id;
	}

	private final void setNumeroIdentificacion(final String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	private final void setNombreCompletoPaciente(final NombreCompletoPacienteEntity nombreCompletoPaciente) {
		this.nombreCompletoPaciente = nombreCompletoPaciente;
	}

	private final void setCorreoElectronicoPaciente(final CorreoElectronicoPacienteEntity correoElectronicoPaciente) {
		this.correoElectronicoPaciente = correoElectronicoPaciente;
	}

	private final void setNumeroTelefonoPaciente(final NumeroTelefonoPacienteEntity numeroTelefonoPaciente) {
		this.numeroTelefonoPaciente = numeroTelefonoPaciente;
	}

	private final void setEstadoCuenta(final boolean estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	private final void setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	private final void setTipoIdentificacion(final TipoIdentificacionEntity tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	private final void setRegimenAfiliacion(final RegimenAfiliacion regimenAfiliacion) {
		this.regimenAfiliacion = regimenAfiliacion;
	}

	private final void setDireccionResidencia(final String direccionResidencia) {
		this.direccionResidencia = direccionResidencia;
	}

	private final void setEps(final Eps eps) {
		this.eps = eps;
	}

	
	
	

}
