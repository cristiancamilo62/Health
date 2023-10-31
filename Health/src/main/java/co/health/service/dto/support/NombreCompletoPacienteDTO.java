package co.health.service.dto.support;

import co.health.crosscutting.util.UtilTexto;

public class NombreCompletoPacienteDTO {
	
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	
	public NombreCompletoPacienteDTO() {
		setPrimerNombre(UtilTexto.VACIO);
		setSegundoNombre(UtilTexto.VACIO);
		setPrimerApellido(UtilTexto.VACIO);
		setSegundoApellido(UtilTexto.VACIO);
	}
	
	public NombreCompletoPacienteDTO(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
	}
	
	public static final NombreCompletoPacienteDTO crear(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		return new NombreCompletoPacienteDTO();
	}

	
	public final String getPrimerNombre() {
		return primerNombre;
	}

	public final NombreCompletoPacienteDTO setPrimerNombre(final String primerNombre) {
		this.primerNombre = primerNombre;
		return this;
	}

	public final String getSegundoNombre() {
		return segundoNombre;
	}

	public final NombreCompletoPacienteDTO setSegundoNombre(final String segundoNombre) {
		this.segundoNombre = segundoNombre;
		return this;
	}

	public final String getPrimerApellido() {
		return primerApellido;
	}

	public final NombreCompletoPacienteDTO setPrimerApellido(final String primerApellido) {
		this.primerApellido = primerApellido;
		return this;
	}

	public final String getSegundoApellido() {
		return segundoApellido;
	}

	public final NombreCompletoPacienteDTO setSegundoApellido(final String segundoApellido) {
		this.segundoApellido = segundoApellido;
		return this;
	}
	
	
	

}
