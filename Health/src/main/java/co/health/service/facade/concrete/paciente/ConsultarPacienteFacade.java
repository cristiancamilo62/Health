package co.health.service.facade.concrete.paciente;


import java.util.ArrayList;
import java.util.List;

import co.health.crosscutting.exception.HealthException;
import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.data.dao.daofactory.DAOFactory;
import co.health.data.dao.daofactory.TipoDAOFactory;
import co.health.data.entity.PacienteEntity;
import co.health.service.businesslogic.concrete.paciente.ConsultarPacienteUseCase;
import co.health.service.domain.paciente.PacienteDomain;
import co.health.service.domain.paciente.rules.PacienteValidationRule;
import co.health.service.dto.PacienteDTO;
import co.health.service.facade.FacadeRetorno;
import co.health.service.mapper.dto.concrete.PacienteDTOMapper;

public final class ConsultarPacienteFacade implements FacadeRetorno<PacienteDTO,List<PacienteEntity>> {

    @Override
    public List<PacienteEntity> executeRetorno(final PacienteDTO dto) {
        List<PacienteEntity> resultados = new ArrayList<>();

        final PacienteDomain domain = PacienteDTOMapper.convertToDomain(dto);
        PacienteValidationRule.ejecutarValidacion(domain);

        final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);

        try {
            daoFactory.iniciarTransaccion();

            var useCase = new ConsultarPacienteUseCase(daoFactory);
            resultados = useCase.executeRetorno(domain);

            daoFactory.confirmarTransaccion();
        } catch (final HealthException exception) {
            daoFactory.cancelarTransacion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransacion();
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de conultar un cliente";
            var mensajeTecnico = "se ha presentado un problema tratando de tipo excepcion tratando de consultar un cliente";
            throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
        return resultados;
    }

}
