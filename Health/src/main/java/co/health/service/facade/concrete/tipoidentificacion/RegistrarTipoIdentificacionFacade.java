package co.health.service.facade.concrete.tipoidentificacion;

import co.health.crosscutting.exception.HealthException;
import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.data.dao.daofactory.DAOFactory;
import co.health.data.dao.daofactory.TipoDAOFactory;
import co.health.service.businesslogic.concrete.tipoidentificacion.RegistrarTipoIdentificacionUseCase;
import co.health.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.health.service.domain.tipoidentificacion.rules.TipoIdentificacionValidationRule;
import co.health.service.dto.TipoIdentificacionDTO;
import co.health.service.facade.Facade;
import co.health.service.mapper.dto.concrete.TipoIdentificacionDTOMapper;

public final class RegistrarTipoIdentificacionFacade implements Facade<TipoIdentificacionDTO>{
	

	public final void execute(final TipoIdentificacionDTO dto) {
		
		
		final TipoIdentificacionDomain domain = TipoIdentificacionDTOMapper.convertToDomain(dto);
		
		TipoIdentificacionValidationRule.ejecutarValidacion(domain);
		
		final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new RegistrarTipoIdentificacionUseCase(daoFactory);
			useCase.execute(domain);
			
			daoFactory.confirmarTransaccion();
		} catch (final HealthException exception) {
			daoFactory.cancelarTransacion();
			throw exception;
		}catch (final Exception exception) {
			daoFactory.cancelarTransacion();
			var mensajeUsuario = "Se ha presentado un problema inesperado tratando de registrar un nuevo tipo de identificación";
			var mensajeTecnico = "se ha presentado un problema tratando de tipo excepcion tratando de registyrar un nuevo numero de identificacion";
			throw ServiceHealthException.crear(mensajeUsuario,mensajeTecnico,exception);
		}
		finally {
			daoFactory.cerrarConexion();
		}
	}	
}
