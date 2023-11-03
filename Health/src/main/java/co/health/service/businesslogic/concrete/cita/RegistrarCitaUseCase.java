package co.health.service.businesslogic.concrete.cita;

import java.util.Optional;
import java.util.UUID;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.dao.CitaDAO;
import co.health.data.dao.PacienteDAO;
import co.health.data.dao.daofactory.DAOFactory;
import co.health.data.entity.CitaEntity;
import co.health.data.entity.PacienteEntity;
import co.health.service.businesslogic.UseCase;
import co.health.service.businesslogic.validator.concrete.cita.RegistrarCitaValidator;
import co.health.service.businesslogic.validator.concrete.paciente.RegistrarPacienteValidator;
import co.health.service.domain.cita.CitaDomain;
import co.health.service.domain.cita.support.DatosServicioCitaDomain;
import co.health.service.domain.cita.support.FechaCitaDomain;
import co.health.service.domain.paciente.PacienteDomain;
import co.health.service.domain.paciente.support.ContactoPacienteDomain;
import co.health.service.mapper.entity.concrete.CitaEntityMapper;
import co.health.service.mapper.entity.concrete.PacienteEntityMapper;

public class RegistrarCitaUseCase implements UseCase<CitaDomain>{

	private DAOFactory factoria;

	public RegistrarCitaUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(CitaDomain domain) {
		
		RegistrarCitaValidator.ejecutarValidacion(domain);
		
		validarNoExistenciaCitaMismaFechaYConsultorio(domain.getFecha(),domain.getDatosServicioCita());

		domain = obtenerIdentificadorCita(domain);

		registrarNuevaCita(domain);
		
	}
	
	private void registrarNuevaCita(final CitaDomain domain ) {
		var entity = CitaEntityMapper.convertToEntity(domain);
		getCitaDAO().registrar(entity);
		
	}
	
	
	private final void validarNoExistenciaCitaMismaFechaYConsultorio(final FechaCitaDomain fechaCita,DatosServicioCitaDomain datosServicioCita) {
		 var entity = crearCitaEntityFechaCitaODatosServicioCita( fechaCita, datosServicioCita);
		    var resultados = getCitaDAO().consultar(entity);
		    if (!resultados.isEmpty()) {
		        String mensajeUsuario = "Ya existe cliente con el numero de teléfono : " ;
		        throw ServiceHealthException.crear(mensajeUsuario);
		    }
	}
	private CitaEntity crearCitaEntityFechaCitaODatosServicioCita(final FechaCitaDomain fechaCita,DatosServicioCitaDomain datosServicioCita) {
	    var domain = CitaDomain.crear(null,datosServicioCita,fechaCita,null,null);
	    return CitaEntityMapper.convertToEntity(domain);
	}
	
	private final CitaDomain obtenerIdentificadorCita(final CitaDomain domain) {
		
		Optional<CitaEntity> optional;
		UUID uuid;
		do {
			uuid = UUID.randomUUID();
			optional = getCitaDAO().consultarPorId(uuid);
		}while(optional.isPresent());
		
		return CitaDomain.crear(domain.getId(),domain.getDatosServicioCita(
				),domain.getFecha(),domain.getEstadoCita(),domain.getNombrePaciente());
	}
	
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final CitaDAO getCitaDAO() {
		return getFactoria().obtenerCitaDAO();
	}

	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo el "
					+ "registro de la información de la nueva cita";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000029);
			var mensajeTecnico = "Se ha presentado un problema en el metodo setFactoria de la clase"
					+ " RegistrarCitaUseCase debido a que la factoria con la cual se desea crear esta nula.";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}


}
