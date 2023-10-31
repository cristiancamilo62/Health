package co.health.service.dto.support;

import co.health.crosscutting.util.UtilTexto;

public class ContactoPacienteDTO {
	private CorreoElectronicoPacienteDTO correoElectronicoPaciente;
	private NumeroTelefonoPacienteDTO numeroTelefonoPaciente;


	public ContactoPacienteDTO() {
		setCorreoElectronicoPaciente(new CorreoElectronicoPacienteDTO());
		setNumeroTelefonoPaciente(new NumeroTelefonoPacienteDTO());
	}
	private ContactoPacienteDTO(final CorreoElectronicoPacienteDTO correoElectronicoPaciente,
			final NumeroTelefonoPacienteDTO numeroTelefonoPaciente) {
		setCorreoElectronicoPaciente(correoElectronicoPaciente);
		setNumeroTelefonoPaciente(numeroTelefonoPaciente);
	}
	
	public static final ContactoPacienteDTO crear (final CorreoElectronicoPacienteDTO correoElectronicoPaciente,
			final NumeroTelefonoPacienteDTO numeroTelefonoPaciente) {
		return new ContactoPacienteDTO(correoElectronicoPaciente, numeroTelefonoPaciente);
	}
	
	public final CorreoElectronicoPacienteDTO getCorreoElectronicoPaciente() {
		return correoElectronicoPaciente;
	}
	public final NumeroTelefonoPacienteDTO getNumeroTelefonoPaciente() {
		return numeroTelefonoPaciente;
	}
	
	public final void setCorreoElectronicoPaciente(final CorreoElectronicoPacienteDTO correoElectronicoPaciente) {
		this.correoElectronicoPaciente = correoElectronicoPaciente;
	}

	public final void setNumeroTelefonoPaciente(final NumeroTelefonoPacienteDTO numeroTelefonoPaciente) {
		this.numeroTelefonoPaciente = numeroTelefonoPaciente;
	}
	
}