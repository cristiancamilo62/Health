package co.health.service.dto.support;

public class DatosServicioCitaDTO {

	private String codigo;
	private int consultorio;
	private String nombreServicio;
	private long precio;
	
	public DatosServicioCitaDTO() {
		//TODO: ORGANIZAR VALORES DEFECTO
		setCodigo(codigo);
		setConsultorio(consultorio);
		setNombreServicio(nombreServicio);
		setPrecio(precio);
	}
	public DatosServicioCitaDTO(final String codigo, final int consultorio, final String nombreServicio, final long precio) {
		setCodigo(codigo);
		setConsultorio(consultorio);
		setNombreServicio(nombreServicio);
		setPrecio(precio);
	}

	public final String getCodigo() {
		return codigo;
	}

	public final DatosServicioCitaDTO setCodigo(final String codigo) {
		this.codigo = codigo;
		return this;
	}

	public final int getConsultorio() {
		return consultorio;
	}

	public final DatosServicioCitaDTO setConsultorio(final int consultorio) {
		this.consultorio = consultorio;
		return this;
	}

	public final String getNombreServicio() {
		return nombreServicio;
	}

	public final DatosServicioCitaDTO setNombreServicio(final String nombreServicio) {
		this.nombreServicio = nombreServicio;
		return this;
	}

	public final long getPrecio() {
		return precio;
	}

	public final DatosServicioCitaDTO setPrecio(final long precio) {
		this.precio = precio;
		return this;
	}
	
	
	

}
