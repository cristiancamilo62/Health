package co.health.data.entity.support;

public class ContactoPacienteEntity {
	private CorreoElectronicoPacienteEntity correoElectronicoPaciente;
	private NumeroTelefonoPacienteEntity numeroTelefonoPaciente;


	private ContactoPacienteEntity(final CorreoElectronicoPacienteEntity correoElectronicoPaciente,
			final NumeroTelefonoPacienteEntity numeroTelefonoPaciente) {
		setCorreoElectronicoPaciente(correoElectronicoPaciente);
		setNumeroTelefonoPaciente(numeroTelefonoPaciente);
	}
	
	public static final ContactoPacienteEntity crear (final CorreoElectronicoPacienteEntity correoElectronicoPaciente,
			final NumeroTelefonoPacienteEntity numeroTelefonoPaciente) {
		return new ContactoPacienteEntity(correoElectronicoPaciente, numeroTelefonoPaciente);
	}
	
	public final CorreoElectronicoPacienteEntity getCorreoElectronicoPaciente() {
		return correoElectronicoPaciente;
	}
	public final NumeroTelefonoPacienteEntity getNumeroTelefonoPaciente() {
		return numeroTelefonoPaciente;
	}


	private final void setCorreoElectronicoPaciente(final CorreoElectronicoPacienteEntity correoElectronicoPaciente) {
		this.correoElectronicoPaciente = correoElectronicoPaciente;
	}

	private final void setNumeroTelefonoPaciente(final NumeroTelefonoPacienteEntity numeroTelefonoPaciente) {
		this.numeroTelefonoPaciente = numeroTelefonoPaciente;
	}


	
}