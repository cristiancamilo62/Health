package co.health.service.mapper.dto.concrete.support;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.paciente.support.NombreCompletoPacienteDomain;
import co.health.service.dto.support.NombreCompletoPacienteDTO;
import co.health.service.mapper.dto.DTOMapper;

public final class NombreCompletoPacienteDTOMapper implements DTOMapper<NombreCompletoPacienteDTO, NombreCompletoPacienteDomain>{

	
	private static final DTOMapper<NombreCompletoPacienteDTO, NombreCompletoPacienteDomain> instancia = new NombreCompletoPacienteDTOMapper();
	
	private NombreCompletoPacienteDTOMapper() {
		super();
	}
	
	
	@Override
	public NombreCompletoPacienteDomain toDomain(NombreCompletoPacienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "No se ha presentado un problema en el metodo toDomain de la clase NombreCompletoPacienteDTOMapper "
					+ "por que el nombreCompletoPaciente es nulo ";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NombreCompletoPacienteDomain.crear(dto.getPrimerNombre(), dto.getSegundoNombre(), dto.getPrimerApellido(), dto.getSegundoApellido());
	}

	@Override
	public final NombreCompletoPacienteDTO toDTO(final NombreCompletoPacienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "No se ha presentado un problema en el metodo toEntity de la clase NombreCompletoPacienteDTOMapper "
					+ "por que el nombreCompletoPaciente es nulo ";
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NombreCompletoPacienteDTO.crear(domain.getPrimerNombre(), domain.getSegundoNombre(), domain.getPrimerApellido(), domain.getSegundoApellido());
	}
	
	public static final NombreCompletoPacienteDomain convertToDomain(final NombreCompletoPacienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final NombreCompletoPacienteDTO convertToDTO(final NombreCompletoPacienteDomain domain) {
		return instancia.toDTO(domain);
	}


}
