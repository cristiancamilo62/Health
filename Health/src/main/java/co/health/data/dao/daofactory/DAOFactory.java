package co.health.data.dao.daofactory;

import co.health.data.dao.CitaDAO;
import co.health.data.dao.EstadoCitaDAO;
import co.health.data.dao.PacienteDAO;
import co.health.data.dao.RegimenAfiliacionDAO;
import co.health.data.dao.TipoIdentificacionDAO;

public abstract class DAOFactory {
	
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
