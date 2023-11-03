package co.health.service.mapper.dto.concrete.support;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.cita.support.FechaCitaDomain;
import co.health.service.dto.support.FechaCitaDTO;
import co.health.service.mapper.dto.DTOMapper;

public class FechaCitaDTOMapper implements DTOMapper<FechaCitaDTO, FechaCitaDomain>{
		
		private static final DTOMapper<FechaCitaDTO, FechaCitaDomain> instancia = new FechaCitaDTOMapper();
		
		private FechaCitaDTOMapper() {
			super();
		}
		@Override
		public FechaCitaDomain toDomain(FechaCitaDTO dto) {
			if(UtilObjeto.esNulo(dto)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000027);
				throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
			}
			return FechaCitaDomain.crear(dto.getFechaInicio(),dto.getFechaFin());
		}
		
		@Override
		public final FechaCitaDTO toDTO(final FechaCitaDomain domain) {
			if(UtilObjeto.esNulo(domain)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000028);
				throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
			}
			return FechaCitaDTO.crear(domain.getFechaInicio(),domain.getFechaFin());
		}
		
		public static final FechaCitaDomain convertToDomain(final FechaCitaDTO entity) {
			return instancia.toDomain(entity);
		}
		
		public static final FechaCitaDTO convertToEntity(final FechaCitaDomain domain) {
			return instancia.toDTO(domain);
		}

}


