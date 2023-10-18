package co.health.data.entity.support;

public class ContactoPacienteEntity {
	private CorreoElectronicoPacienteEntity correoElectronicoPaciente;
	private NumeroTelefonoPacienteEntity numeroTelefonoPaciente;
	private String direccion;


	private ContactoPacienteEntity(final CorreoElectronicoPacienteEntity correoElectronicoPaciente,
			final NumeroTelefonoPacienteEntity numeroTelefonoPaciente, final String direccion) {
		setCorreoElectronicoPaciente(correoElectronicoPaciente);
		setNumeroTelefonoPaciente(numeroTelefonoPaciente);
		setDireccion(direccion);
	}
	
	public static final ContactoPacienteEntity crear (final CorreoElectronicoPacienteEntity correoElectronicoPaciente,
			final NumeroTelefonoPacienteEntity numeroTelefonoPaciente, final String direccion) {
		return new ContactoPacienteEntity(correoElectronicoPaciente, numeroTelefonoPaciente,direccion);
	}
	
	public final CorreoElectronicoPacienteEntity getCorreoElectronicoPaciente() {
		return correoElectronicoPaciente;
	}
	public final NumeroTelefonoPacienteEntity getNumeroTelefonoPaciente() {
		return numeroTelefonoPaciente;
	}
	

	public final String getDireccion() {
		return direccion;
	}

	private final void setCorreoElectronicoPaciente(final CorreoElectronicoPacienteEntity correoElectronicoPaciente) {
		this.correoElectronicoPaciente = correoElectronicoPaciente;
	}

	private final void setNumeroTelefonoPaciente(final NumeroTelefonoPacienteEntity numeroTelefonoPaciente) {
		this.numeroTelefonoPaciente = numeroTelefonoPaciente;
	}

	private final void setDireccion(final String direccion) {
		this.direccion = direccion;
	}
	
	
	
}