package co.health.service.domain.paciente.rules;

import co.health.service.domain.ValidationRule;
import co.health.service.domain.eps.rules.EpsPacienteValidationRule;
import co.health.service.domain.eps.rules.NombreEpsValidationRule;
import co.health.service.domain.eps.rules.idEpsValidationRule;
import co.health.service.domain.paciente.support.InformacionAfiliacionPacienteDomain;
import co.health.service.domain.regimenafiliacion.rules.IdRegimenAfiliacionValidationRule;
import co.health.service.domain.regimenafiliacion.rules.RegimenAfiliacionValidationRule;
import co.health.service.domain.regimenafiliacion.rules.ServiciosRegimenAfiliacionValidationRule;
import co.health.service.domain.regimenafiliacion.rules.TipoRegimenAfiliacionValidationRule;

public final class InformacionAfiliacionPacienteValidationRule implements ValidationRule<InformacionAfiliacionPacienteDomain>{
	
	private static final ValidationRule<InformacionAfiliacionPacienteDomain> instancia = new InformacionAfiliacionPacienteValidationRule();
	
	private   InformacionAfiliacionPacienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final InformacionAfiliacionPacienteDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(InformacionAfiliacionPacienteDomain dato) {
		//EpsPacienteValidationRule.ejecutarValidacion(dato.getEps());
		//idEpsValidationRule.ejecutarValidacion(dato.getEps().getId());
		//NombreEpsValidationRule.ejecutarValidacion(dato.getEps().getNombre());
		//RegimenAfiliacionValidationRule.ejecutarValidacion(dato.getRegimenAfiliacion());
		//IdRegimenAfiliacionValidationRule.ejecutarValidacion(dato.getRegimenAfiliacion().getId());
		//TipoRegimenAfiliacionValidationRule.ejecutarValidacion(dato.getRegimenAfiliacion().getTipo());
		//ServiciosRegimenAfiliacionValidationRule.ejecutarValidacion(dato.getRegimenAfiliacion().getCoberturaServicios());
		
	}
}
