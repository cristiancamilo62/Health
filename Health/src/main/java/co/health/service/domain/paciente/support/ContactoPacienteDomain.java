package co.health.service.domain.paciente.support;

import co.health.crosscutting.util.UtilObjeto;


public final class ContactoPacienteDomain {
	
	private CorreoElectronicoPacienteDomain correoElectronicoPaciente;
	private NumeroTelefonoPacienteDomain numeroTelefonoPaciente;

	public ContactoPacienteDomain() {
		setCorreoElectronicoPaciente(new CorreoElectronicoPacienteDomain());
		setNumeroTelefonoPaciente(new NumeroTelefonoPacienteDomain());
	}

	private ContactoPacienteDomain(final CorreoElectronicoPacienteDomain correoElectronicoPaciente,
			final NumeroTelefonoPacienteDomain numeroTelefonoPaciente) {
		setCorreoElectronicoPaciente(correoElectronicoPaciente);
		setNumeroTelefonoPaciente(numeroTelefonoPaciente);
	}
	
	public static final ContactoPacienteDomain crear (final CorreoElectronicoPacienteDomain correoElectronicoPaciente,
			final NumeroTelefonoPacienteDomain numeroTelefonoPaciente) {
		return new ContactoPacienteDomain(correoElectronicoPaciente, numeroTelefonoPaciente);
	}
	
	public static final ContactoPacienteDomain crear() {
		return new ContactoPacienteDomain();
	}
	
	public final CorreoElectronicoPacienteDomain getCorreoElectronicoPaciente() {
		return correoElectronicoPaciente;
	}
	public final NumeroTelefonoPacienteDomain getNumeroTelefonoPaciente() {
		return numeroTelefonoPaciente;
	}


	private final void setCorreoElectronicoPaciente(final CorreoElectronicoPacienteDomain correoElectronicoPaciente) {
		this.correoElectronicoPaciente = UtilObjeto.obtenerValorDefecto(correoElectronicoPaciente, new CorreoElectronicoPacienteDomain());
	}

	private final void setNumeroTelefonoPaciente(final NumeroTelefonoPacienteDomain numeroTelefonoPaciente) {
		this.numeroTelefonoPaciente = UtilObjeto.obtenerValorDefecto(numeroTelefonoPaciente, new NumeroTelefonoPacienteDomain());
	}


}
