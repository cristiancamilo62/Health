package co.health.data.dao.daofactory.concrete;

import java.sql.Connection;
import java.sql.SQLException;

import co.health.crosscutting.exception.concrete.DataHealthException;
import co.health.crosscutting.util.UtilSQL;
import co.health.data.dao.CitaDAO;
import co.health.data.dao.EstadoCitaDAO;
import co.health.data.dao.PacienteDAO;
import co.health.data.dao.RegimenAfiliacionDAO;
import co.health.data.dao.TipoIdentificacionDAO;
import co.health.data.dao.concrete.sqlserver.CitaSQLServerDAO;
import co.health.data.dao.concrete.sqlserver.EstadoCitaSQLServerDAO;
import co.health.data.dao.concrete.sqlserver.PacienteSQLServerDAO;
import co.health.data.dao.concrete.sqlserver.RegimenAfiliacionSQLServerDAO;
import co.health.data.dao.concrete.sqlserver.TipoIdentificacionSQLServerDAO;
import co.health.data.dao.daofactory.DAOFactory;

public final class SQLServerDAOFactory extends DAOFactory {

	private Connection conexion;
	
	public SQLServerDAOFactory() {
		abrirConexion();
	}
	@Override
	protected final void abrirConexion() {
		try {
			conexion=null;
		}catch (SQLException exception) {
			throw DataHealthException.crear(null, null, exception);
		}catch (ClassNotFoundException exception) {
			throw DataHealthException.crear(null, null, exception);
		}catch (Exception exception) {
			throw DataHealthException.crear(null, null, exception);
		} 
	}

	@Override
	public final void cerrarConexion() {
		UtilSQL.cerrarConexion(conexion);
	}

	@Override
	public final void IniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
	}

	@Override
	public final void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);
	}

	@Override
	public final void cancelarTransaccion() {
		UtilSQL.cancelarTransaccion(conexion);
	}

	@Override
	public TipoIdentificacionDAO obtenerTipoIdentificacionDAO() {
		return new TipoIdentificacionSQLServerDAO(conexion); 
	}
	@Override
	public CitaDAO obtenerCitaDAO() {
		return new CitaSQLServerDAO(conexion);
	}
	@Override
	public PacienteDAO obtenerPacienteDAO() {
		return new PacienteSQLServerDAO(conexion);
	}
	@Override
	public RegimenAfiliacionDAO obtenerRegimenAfiliacionDAO() {
		return new RegimenAfiliacionSQLServerDAO(conexion);
	}
	@Override
	public EstadoCitaDAO obtenerEstadoCitaDAO() {
		return new EstadoCitaSQLServerDAO(conexion);
	}
			
}
