package co.health.service.mapper.dto.concrete.support;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.paciente.support.InformacionAfiliacionPacienteDomain;
import co.health.service.dto.support.InformacionAfiliacionPacienteDTO;
import co.health.service.mapper.dto.DTOMapper;

public final class InformacionAfiliacionPacienteDTOMapper implements DTOMapper<InformacionAfiliacionPacienteDTO, InformacionAfiliacionPacienteDomain>{

	private static final DTOMapper<InformacionAfiliacionPacienteDTO, InformacionAfiliacionPacienteDomain> instancia = new InformacionAfiliacionPacienteDTOMapper();
	
	private InformacionAfiliacionPacienteDTOMapper() {
		super();
	}
	
	@Override
	public final InformacionAfiliacionPacienteDomain toDomain(final InformacionAfiliacionPacienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "el InformacionAfliacionPaciente es nulo en toDomain de la clase InformacionAfiliacionPacienteDTOMapper";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return InformacionAfiliacionPacienteDomain.crear(false, null, null);
	}

	@Override
	public final InformacionAfiliacionPacienteDTO toDTO(final InformacionAfiliacionPacienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "el InformacionAfliacionPaciente es nulo en toEntity de la clase InformacionAfiliacionPacienteDTOMapper";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return InformacionAfiliacionPacienteDTO.crear(false, null, null);
	}
	
	public static final InformacionAfiliacionPacienteDomain convertToDomain(final InformacionAfiliacionPacienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final InformacionAfiliacionPacienteDTO convertToDTO(final InformacionAfiliacionPacienteDomain domain) {
		return instancia.toDTO(domain);
	}

}
