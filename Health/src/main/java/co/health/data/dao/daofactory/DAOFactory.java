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
		case POSTGRESSQL:{
			//TODO: Falta mejorar el manejo de excepciones customizadas
			throw new RuntimeException("Factoria no soportada");
		}
		case MYSQL:{
			//TODO: Falta mejorar el manejo de excepciones customizadas
			throw new RuntimeException("Factoria no soportada");
		}
		case ORACLE:{
			//TODO: Falta mejorar el manejo de excepciones customizadas
			throw new RuntimeException("Factoria no soportada");
		}
		default:
			throw new RuntimeException("Factoria no soportada");
		}
	}
	
	protected abstract void abrirConexion();
	
	public abstract void cerrarConexion();
	
	public abstract void IniciarTransaccion();
	
	public abstract void confirmarTransaccion();
	
	public abstract void cancelarTransaccion();

	public abstract CitaDAO obtenerCitaDAO();
	
	public abstract TipoIdentificacionDAO obtenerTipoIdentificacionDAO();
	
	public abstract PacienteDAO obtenerPacienteDAO();
	
	public abstract RegimenAfiliacionDAO obtenerRegimenAfiliacionDAO();
	
	public abstract EstadoCitaDAO obtenerEstadoCitaDAO();
	
}
