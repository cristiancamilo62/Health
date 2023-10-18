package co.health.data.dao.daofactory.concrete;

import java.sql.Connection;
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
		UtilSQL.cerrarConexion(conexion);
	}

	@Override
	public final void iniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
	}

	@Override
	public final void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);
	}

	@Override
	public final void cancelarTransaciion() {
		UtilSQL.cancelarTransaccion(conexion);
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
