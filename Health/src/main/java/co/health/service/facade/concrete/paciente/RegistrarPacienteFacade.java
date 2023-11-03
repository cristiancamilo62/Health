package co.health.service.facade.concrete.paciente;

import co.health.crosscutting.exception.HealthException;
import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.data.dao.daofactory.DAOFactory;
import co.health.data.dao.daofactory.TipoDAOFactory;
import co.health.service.businesslogic.concrete.paciente.RegistrarPacienteUseCase;
import co.health.service.domain.paciente.PacienteDomain;
import co.health.service.domain.paciente.rules.PacienteValidationRule;
import co.health.service.dto.PacienteDTO;
import co.health.service.facade.Facade;
import co.health.service.mapper.dto.concrete.PacienteDTOMapper;

public final class RegistrarPacienteFacade implements Facade<PacienteDTO>{

	@Override
	public void execute(PacienteDTO dto) {
		

		final PacienteDomain domain = PacienteDTOMapper.convertToDomain(dto);
		PacienteValidationRule.ejecutarValidacion(domain);
		
		final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new RegistrarPacienteUseCase(daoFactory);
			useCase.execute(domain);
			
			daoFactory.confirmarTransaccion();
		} catch (final HealthException exception) {
			daoFactory.cancelarTransacion();
			throw exception;
		}catch (final Exception exception) {
			daoFactory.cancelarTransacion();
			var mensajeUsuario = "Se ha presentado un problema inesperado tratando de registrar un nuevo cliente";
			var mensajeTecnico = "se ha presentado un problema tratando de tipo excepcion tratando de registrar un nuevo cliente";
			throw ServiceHealthException.crear(mensajeUsuario,mensajeTecnico,exception);
		}
		finally {
			daoFactory.cerrarConexion();
		}
	}

	

}
