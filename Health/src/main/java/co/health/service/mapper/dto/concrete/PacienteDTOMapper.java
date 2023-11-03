package co.health.service.mapper.dto.concrete;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.paciente.PacienteDomain;
import co.health.service.dto.PacienteDTO;
import co.health.service.mapper.dto.DTOMapper;
import co.health.service.mapper.dto.concrete.support.ContactoPacienteDTOMapper;
import co.health.service.mapper.dto.concrete.support.InformacionAfiliacionPacienteDTOMapper;
import co.health.service.mapper.dto.concrete.support.NombreCompletoPacienteDTOMapper;


public final class PacienteDTOMapper implements DTOMapper<PacienteDTO, PacienteDomain>{

	private static final DTOMapper<PacienteDTO, PacienteDomain> instancia = new PacienteDTOMapper();
	
	private PacienteDTOMapper() {
		super();
	}
	
	@Override
	public PacienteDomain toDomain(PacienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "el PacienteEntity es nulo en toDomain de la clase PacienteDTOMapper";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return PacienteDomain.crear(dto.getId(),dto.getNumeroIdentificacion(), NombreCompletoPacienteDTOMapper.convertToDomain(dto.getNombreCompletoPaciente()),
				ContactoPacienteDTOMapper.convertToDomain(dto.getContactoPaciente()), dto.getFechaNacimiento(), TipoIdentificacionDTOMapper.convertToDomain(dto.getTipoIdentificacion()),
				InformacionAfiliacionPacienteDTOMapper.convertToDomain(dto.getInformacionAfiliacionPaciente()));
	}

	@Override
	public PacienteDTO toDTO(PacienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "el PacienteEntity es nulo en toEntity de la clase PacienteEntityMapper";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return PacienteDTO.crear(domain.getId(),domain.getNumeroIdentificacion(), NombreCompletoPacienteDTOMapper.convertToDTO(domain.getNombreCompletoPaciente()),
				ContactoPacienteDTOMapper.convertToDTO(domain.getContactoPaciente()), domain.getFechaNacimiento(), TipoIdentificacionDTOMapper.convertToDTO(domain.getTipoIdentificacion()),
				InformacionAfiliacionPacienteDTOMapper.convertToDTO(domain.getInformacionAfiliacionPaciente()));
	}
	
	public static final PacienteDomain convertToDomain(final PacienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final PacienteDTO convertToDTO(final PacienteDomain domain) {
		return instancia.toDTO(domain);
	}

}
