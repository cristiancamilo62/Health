package co.health.data.dao.daofactory.concrete;

import java.sql.Connection;

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

public final class SQLServerDAOFactory extends DAOFactory{
	
	private Connection conexion;
	
	public SQLServerDAOFactory() {
		abrirconexion();
	}

	@Override
	protected final void abrirconexion() {
		// TODO: Your homework will be to obtain connection SQL Server database
		conexion = null;
	}

	@Override
	public final void cerrarConexion() {
		// TODO: Your homework will be to close connection SQL Server database
		
	}

	@Override
	public final void iniciarTransaccion() {
		// TODO: Your homework will be to init transaction
		
	}

	@Override
	public final void confirmarTransaccion() {
		// TODO: Your homework will be to commit transaction
	}

	@Override
	public final void cancelarTransaciion() {
		// // TODO: Your homework will be rollback transaction
		
	}

	@Override
	public PacienteDAO obtenerPacienteDao() {
		return new PacienteSQLServerDAO(conexion);
	}

	@Override
	public TipoIdentificacionDAO obtenerTipoIdentificacionDao() {
		return new TipoIdentificacionSQLServerDAO(conexion);
	}

	@Override
	public CitaDAO obtenerCitaDao() {
		return new CitaSQLServerDAO(conexion);
	}

	@Override
	public EstadoCitaDAO obtenerEstadoCitaDao() {
		return new EstadoCitaSQLServerDAO(conexion);
	}

	@Override
	public RegimenAfiliacionDAO obtenerRegimenAfiliacionDao() {
		return new RegimenAfiliacionSQLServerDAO(conexion);
	}

}
