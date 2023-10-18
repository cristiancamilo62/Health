package co.health.data.dao.daofactory;

import co.health.data.dao.CitaDAO;
import co.health.data.dao.EstadoCitaDAO;
import co.health.data.dao.PacienteDAO;
import co.health.data.dao.RegimenAfiliacionDAO;
import co.health.data.dao.TipoIdentificacionDAO;
import co.health.data.dao.daofactory.concrete.SQLServerDAOFactory;

public abstract class DAOFactory {
	
	
	public static final DAOFactory obtenerDAOFactory(final TipoDAOFactory factoria) {
		switch (factoria) {
		case SQLSERVER: {
			return new SQLServerDAOFactory();
		}
		case POSTGRESQL: {
			//TODO: falta mejorar el manejo de excepciones customizadas
			throw new RuntimeException("factoria no implementada");
		}
		case MYSQL: {
			//TODO: falta mejorar el manejo de excepciones customizadas
			throw new RuntimeException("factoria no implementada");
		}
		case ORACLE: {
			//TODO: falta mejorar el manejo de excepciones customizadas
			throw new RuntimeException("factoria no implementada");
		}
		default:
			//TODO: falta mejorar el manejo de excepciones customizadas
			throw new RuntimeException("factoria no implementada");
		}
	}
	
	protected abstract void abrirconexion();
	public abstract void cerrarConexion();
	public abstract void iniciarTransaccion();
	public abstract void confirmarTransaccion();
	public abstract void cancelarTransaciion();
	public abstract PacienteDAO obtenerPacienteDao();
	public abstract TipoIdentificacionDAO obtenerTipoIdentificacionDao();
	public abstract CitaDAO obtenerCitaDao();
	public abstract EstadoCitaDAO obtenerEstadoCitaDao();
	public abstract RegimenAfiliacionDAO obtenerRegimenAfiliacionDao(); 
	

}
