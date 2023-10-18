package co.health.data.entity.support;

public class DatosServicioCitaEntity {
	private String codigo;
	private int consultorio;
	private String nombreServicio;
	private long precio;
	
	
	private DatosServicioCitaEntity(final String codigo, final int consultorio, final String nombreServicio,
		final long precio) {
		setConsultorio(consultorio);
		setPrecio(precio);
		setNombreServicio(nombreServicio);
		setCodigo(codigo);
	}
	
	public static final DatosServicioCitaEntity crear(final String codigo,final int consultorio, final String nombreServicio, 
			final long precio) {
		return new DatosServicioCitaEntity(codigo,consultorio, nombreServicio, precio);
	}

	public final int getConsultorio() {
		return consultorio;
	}

	public final String getNombreServicio() {
		return nombreServicio;
	}

	public final long getPrecio() {
		return precio;
	}
	
	public final String getCodigo() {
		return codigo;
	}

	private final void setConsultorio(final int consultorio) {
		this.consultorio = consultorio;
	}

	private final void setNombreServicio(final String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	private final void setPrecio(final long precio) {
		this.precio = precio;
	}

	private final void setCodigo(final String codigo) {
		this.codigo = codigo;
	}
	
	
	
}