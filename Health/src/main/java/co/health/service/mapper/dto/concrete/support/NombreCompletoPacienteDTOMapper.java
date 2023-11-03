package co.health.service.mapper.dto.concrete.support;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.paciente.support.NombreCompletoDomain;
import co.health.service.dto.support.NombreCompletoDTO;
import co.health.service.mapper.dto.DTOMapper;

public final class NombreCompletoPacienteDTOMapper implements DTOMapper<NombreCompletoDTO, NombreCompletoDomain>{

	
	private static final DTOMapper<NombreCompletoDTO, NombreCompletoDomain> instancia = new NombreCompletoPacienteDTOMapper();
	
	private NombreCompletoPacienteDTOMapper() {
		super();
	}
	
	
	@Override
	public NombreCompletoDomain toDomain(NombreCompletoDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "No se ha presentado un problema en el metodo toDomain de la clase NombreCompletoPacienteDTOMapper "
					+ "por que el nombreCompletoPaciente es nulo ";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NombreCompletoDomain.crear(dto.getPrimerNombre(), dto.getSegundoNombre(), dto.getPrimerApellido(), dto.getSegundoApellido());
	}

	@Override
	public final NombreCompletoDTO toDTO(final NombreCompletoDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "No se ha presentado un problema en el metodo toEntity de la clase NombreCompletoPacienteDTOMapper "
					+ "por que el nombreCompletoPaciente es nulo ";
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NombreCompletoDTO.crear(domain.getPrimerNombre(), domain.getSegundoNombre(), domain.getPrimerApellido(), domain.getSegundoApellido());
	}
	
	public static final NombreCompletoDomain convertToDomain(final NombreCompletoDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final NombreCompletoDTO convertToDTO(final NombreCompletoDomain domain) {
		return instancia.toDTO(domain);
	}


}
