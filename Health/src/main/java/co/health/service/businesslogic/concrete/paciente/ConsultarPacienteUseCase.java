package co.health.service.businesslogic.concrete.paciente;


import java.util.List;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.dao.PacienteDAO;
import co.health.data.dao.daofactory.DAOFactory;
import co.health.data.entity.PacienteEntity;
import co.health.service.businesslogic.UseCaseRetorno;
import co.health.service.domain.paciente.PacienteDomain;
import co.health.service.mapper.entity.concrete.PacienteEntityMapper;

public final class ConsultarPacienteUseCase implements UseCaseRetorno<PacienteDomain,List<PacienteEntity>>{

	private DAOFactory factoria;

	public ConsultarPacienteUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	
	@Override
	public final List<PacienteEntity> executeRetorno(final PacienteDomain domain) {
		var entity = crearPacienteEntityIdAConsultar(domain);
	    var resultados = getPacienteDAO().consultar(entity);
	    if (resultados.isEmpty()) {
	        String mensajeUsuario = "No existe el cliente con el identificar que se desea consultar";
	        throw ServiceHealthException.crear(mensajeUsuario);
	    }
	    return resultados;
	}
	private PacienteEntity crearPacienteEntityIdAConsultar(final PacienteDomain domain) {
	    return PacienteEntityMapper.convertToEntity(domain);
	}
	
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final PacienteDAO getPacienteDAO() {
		return getFactoria().obtenerPacienteDAO();
	}

	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo el "
					+ "registro de la información del nuevo cliente";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000029);
			var mensajeTecnico = "Se ha presentado un problema en el metodo setFactoria de la clase"
					+ " RegistrarPacienteUseCase debido a que la factoria con la cual se desea crear esta nula.";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}



}
