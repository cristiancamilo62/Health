package co.health.service.dto.support;

public class ContactoPacienteDTO {
	private CorreoElectronicoPacienteDTO correoElectronicoPaciente;
	private NumeroTelefonoPacienteDTO numeroTelefonoPaciente;
	private String direccion;


	private ContactoPacienteDTO(final CorreoElectronicoPacienteDTO correoElectronicoPaciente,
			final NumeroTelefonoPacienteDTO numeroTelefonoPaciente, final String direccion) {
		setCorreoElectronicoPaciente(correoElectronicoPaciente);
		setNumeroTelefonoPaciente(numeroTelefonoPaciente);
		setDireccion(direccion);
	}
	
	public static final ContactoPacienteDTO crear (final CorreoElectronicoPacienteDTO correoElectronicoPaciente,
			final NumeroTelefonoPacienteDTO numeroTelefonoPaciente, final String direccion) {
		return new ContactoPacienteDTO(correoElectronicoPaciente, numeroTelefonoPaciente,direccion);
	}
	
	public final CorreoElectronicoPacienteDTO getCorreoElectronicoPaciente() {
		return correoElectronicoPaciente;
	}
	public final NumeroTelefonoPacienteDTO getNumeroTelefonoPaciente() {
		return numeroTelefonoPaciente;
	}
	

	public final String getDireccion() {
		return direccion;
	}

	public final void setCorreoElectronicoPaciente(final CorreoElectronicoPacienteDTO correoElectronicoPaciente) {
		this.correoElectronicoPaciente = correoElectronicoPaciente;
	}

	public final void setNumeroTelefonoPaciente(final NumeroTelefonoPacienteDTO numeroTelefonoPaciente) {
		this.numeroTelefonoPaciente = numeroTelefonoPaciente;
	}

	public final void setDireccion(final String direccion) {
		this.direccion = direccion;
	}
	
	
	
}