package co.health.service.dto.support;

public class CorreoElectronicoPacienteDTO {
	private String correoElectronico;
	private boolean correoELectronicoConfirmado;
	
	
	private CorreoElectronicoPacienteDTO(final String correoElectronico, final boolean correoELectronicoConfirmado) {
		setCorreoElectronico(correoElectronico);
		setCorreoELectronicoConfirmado(correoELectronicoConfirmado);
	}
	
	public static final CorreoElectronicoPacienteDTO crear(final String correoElectronico, final boolean correoELectronicoConfirmado) {
		return new CorreoElectronicoPacienteDTO(correoElectronico, correoELectronicoConfirmado);
	}

	public final String getCorreoElectronico() {
		return correoElectronico;
	}


	public final boolean isCorreoELectronicoConfirmado() {
		return correoELectronicoConfirmado;
	}

	public final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public final void setCorreoELectronicoConfirmado(final boolean correoELectronicoConfirmado) {
		this.correoELectronicoConfirmado = correoELectronicoConfirmado;
	}
	
	
	
}