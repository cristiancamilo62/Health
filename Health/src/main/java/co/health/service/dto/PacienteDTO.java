package co.health.service.dto;

import java.sql.Date;
import java.util.UUID;

import co.health.service.dto.support.ContactoPacienteDTO;
import co.health.service.dto.support.InformacionAfiliacionPacienteDTO;
import co.health.service.dto.support.NombreCompletoPacienteDTO;

public class PacienteDTO {
	
	private UUID id;
	private String numeroIdentificacion;
	private NombreCompletoPacienteDTO nombreCompletoPaciente;
	private ContactoPacienteDTO contactoPaciente;
	private Date fechaNacimiento;
	private TipoIdentificacionDTO tipoIdentificacion;
	private InformacionAfiliacionPacienteDTO informacionAfiliacionPaciente;
	
	public PacienteDTO() {
		//TODO : ORGANIZAR VALORES DEFECTO
		setId(id);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombreCompletoPaciente(nombreCompletoPaciente);
		setContactoPaciente(contactoPaciente);
		setFechaNacimiento(fechaNacimiento);
		setTipoIdentificacion(tipoIdentificacion);
		setInformacionAfiliacionPaciente(informacionAfiliacionPaciente);
	}
	
	public PacienteDTO(final UUID id, final String numeroIdentificacion, final NombreCompletoPacienteDTO nombreCompletoPaciente,
			final ContactoPacienteDTO contactoPaciente, final Date fechaNacimiento, final TipoIdentificacionDTO tipoIdentificacion,
			final InformacionAfiliacionPacienteDTO informacionAfiliacionPaciente) {
		setId(id);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombreCompletoPaciente(nombreCompletoPaciente);
		setContactoPaciente(contactoPaciente);
		setFechaNacimiento(fechaNacimiento);
		setTipoIdentificacion(tipoIdentificacion);
		setInformacionAfiliacionPaciente(informacionAfiliacionPaciente);
	}

	public final UUID getId() {
		return id;
	}

	public final PacienteDTO setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public final PacienteDTO setNumeroIdentificacion(final String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
		return this;
	}

	public final NombreCompletoPacienteDTO getNombreCompletoPaciente() {
		return nombreCompletoPaciente;
	}

	public final PacienteDTO setNombreCompletoPaciente(final NombreCompletoPacienteDTO nombreCompletoPaciente) {
		this.nombreCompletoPaciente = nombreCompletoPaciente;
		return this;
	}

	public final ContactoPacienteDTO getContactoPaciente() {
		return contactoPaciente;
	}

	public final PacienteDTO setContactoPaciente(final ContactoPacienteDTO contactoPaciente) {
		this.contactoPaciente = contactoPaciente;
		return this;
	}

	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public final PacienteDTO setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}

	public final TipoIdentificacionDTO getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public final PacienteDTO setTipoIdentificacion(final TipoIdentificacionDTO tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
		return this;
	}

	public final InformacionAfiliacionPacienteDTO getInformacionAfiliacionPaciente() {
		return informacionAfiliacionPaciente;
	}

	public final PacienteDTO setInformacionAfiliacionPaciente(final InformacionAfiliacionPacienteDTO informacionAfiliacionPaciente) {
		this.informacionAfiliacionPaciente = informacionAfiliacionPaciente;
		return this;
	}
	
	

}
