package co.health.data.entity;

import java.util.UUID;

import co.health.data.entity.support.FechaCitaEntity;
import co.health.data.entity.support.DatosServicioCitaEntity;


public class CitaEntity {
	
	private UUID id;
	private DatosServicioCitaEntity datosServicioCita;
	private FechaCitaEntity fecha;
	private AgendaEntity agenda;
	private FacturaEntity factura;
	private EstadoCitaEntity estadoCita;
	private PacienteEntity paciente;
	
	
	private CitaEntity(final UUID id, final DatosServicioCitaEntity datosServicioCita, final FechaCitaEntity fecha, final AgendaEntity agenda,
			final FacturaEntity factura, final EstadoCitaEntity estadoCita, final PacienteEntity paciente) {
		setId(id);
		setDatosServicioCita(datosServicioCita);
		setFecha(fecha);
		setAgenda(agenda);
		setFactura(factura);
		setEstadoCita(estadoCita);
		setPaciente(paciente);
	}

	public static final CitaEntity crear(final UUID id, final DatosServicioCitaEntity datosServicioCita, final FechaCitaEntity fecha, final AgendaEntity agenda,
			final FacturaEntity factura, final EstadoCitaEntity estadoCita, final PacienteEntity paciente) {
		return new CitaEntity(id, datosServicioCita, fecha, agenda, factura, estadoCita, paciente);
	}

	public final UUID getId() {
		return id;
	}

	public final DatosServicioCitaEntity getDatosServicioCita() {
		return datosServicioCita;
	}

	public final FechaCitaEntity getFecha() {
		return fecha;
	}

	public final AgendaEntity getAgenda() {
		return agenda;
	}

	public final FacturaEntity getFactura() {
		return factura;
	}

	public final EstadoCitaEntity getEstadoCita() {
		return estadoCita;
	}

	public final PacienteEntity getPaciente() {
		return paciente;
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setDatosServicioCita(final DatosServicioCitaEntity datosServicioCita) {
		this.datosServicioCita = datosServicioCita;
	}

	private final void setFecha(final FechaCitaEntity fecha) {
		this.fecha = fecha;
	}

	private final void setAgenda(final AgendaEntity agenda) {
		this.agenda = agenda;
	}
	
	private final void setFactura(final FacturaEntity factura) {
		this.factura = factura;
	}

	private final void setEstadoCita(final EstadoCitaEntity estadoCita) {
		this.estadoCita = estadoCita;
	}
	
	private final void setPaciente(final PacienteEntity paciente) {
		this.paciente = paciente;
	}

}
