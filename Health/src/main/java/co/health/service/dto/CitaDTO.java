package co.health.service.dto;

import java.util.UUID;

import co.health.crosscutting.util.UtilUuid;
import co.health.service.dto.support.DatosServicioCitaDTO;
import co.health.service.dto.support.FechaCitaDTO;
import co.health.service.dto.support.NombreCompletoPacienteDTO;

public class CitaDTO {
	private UUID id;
	private DatosServicioCitaDTO datosServicioCita;
	private FechaCitaDTO fecha;
	private EstadoCitaDTO estadoCita;
	private NombreCompletoPacienteDTO nombrePaciente;
	
	
	public CitaDTO() {
		setId(UtilUuid.DEFAULT_UUID);
		setDatosServicioCita(new DatosServicioCitaDTO());
		setFecha(new FechaCitaDTO());
		setEstadoCita(new EstadoCitaDTO());
		setNombrePaciente(new NombreCompletoPacienteDTO());
		}
	public CitaDTO(final UUID id, final DatosServicioCitaDTO datosServicioCita, final FechaCitaDTO fecha,
			 final EstadoCitaDTO estadoCita, final NombreCompletoPacienteDTO nombrePaciente) {
		setId(id);
		setDatosServicioCita(datosServicioCita);
		setFecha(fecha);
		setEstadoCita(estadoCita);
		setNombrePaciente(nombrePaciente);		
	}

	public static final CitaDTO crear(final UUID id, final DatosServicioCitaDTO datosServicioCita, final FechaCitaDTO fecha, 
			 final EstadoCitaDTO estadoCita, final NombreCompletoPacienteDTO nombrePaciente) {
		return new CitaDTO(id, datosServicioCita, fecha ,estadoCita, nombrePaciente);
	}
	
	public static final CitaDTO crear() {
		return new CitaDTO();
	}
	public final UUID getId() {
		return id;
	}

	public final DatosServicioCitaDTO getDatosServicioCita() {
		return datosServicioCita;
	}

	public final FechaCitaDTO getFecha() {
		return fecha;
	}


	public final EstadoCitaDTO getEstadoCita() {
		return estadoCita;
	}

	
	public final NombreCompletoPacienteDTO getNombrePaciente() {
		return nombrePaciente;
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setDatosServicioCita(final DatosServicioCitaDTO datosServicioCita) {
		this.datosServicioCita = datosServicioCita;
	}

	private final void setFecha(final FechaCitaDTO fecha) {
		this.fecha = fecha;
	}

	
	private final void setEstadoCita(final EstadoCitaDTO estadoCita) {
		this.estadoCita = estadoCita;
	}

	private final void setNombrePaciente(NombreCompletoPacienteDTO nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	
	
	
	
}

