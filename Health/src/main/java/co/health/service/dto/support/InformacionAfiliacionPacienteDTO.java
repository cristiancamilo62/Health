package co.health.service.dto.support;


import co.health.service.dto.EpsDTO;
import co.health.service.dto.RegimenAfiliacionDTO;

public class InformacionAfiliacionPacienteDTO {

	private boolean estadoCuenta;
	private RegimenAfiliacionDTO regimenAfiliacion;
	private EpsDTO eps;
	
	public InformacionAfiliacionPacienteDTO() {
		
	}
	public InformacionAfiliacionPacienteDTO(boolean estadoCuenta, RegimenAfiliacionDTO regimenAfiliacion,
			EpsDTO eps) {
		setEstadoCuenta(estadoCuenta);
		setRegimenAfiliacion(regimenAfiliacion);
		setEps(eps);
	}
	public final boolean isEstadoCuenta() {
		return estadoCuenta;
	}
	public final InformacionAfiliacionPacienteDTO setEstadoCuenta(final boolean estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
		return this;
	}
	public final RegimenAfiliacionDTO getRegimenAfiliacion() {
		return regimenAfiliacion;
	}
	public final InformacionAfiliacionPacienteDTO setRegimenAfiliacion(final RegimenAfiliacionDTO regimenAfiliacion) {
		this.regimenAfiliacion = regimenAfiliacion;
		return this;
	}
	public final EpsDTO getEps() {
		return eps;
	}
	public final InformacionAfiliacionPacienteDTO setEps(EpsDTO eps) {
		this.eps = eps;
		return this;
	}
	
	
	
	
}