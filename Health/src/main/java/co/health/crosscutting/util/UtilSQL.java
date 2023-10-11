package co.health.crosscutting.util;

import java.sql.Connection;
import java.sql.SQLException;

import co.health.crosscutting.exception.concrete.CrosscuttingHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;


public final class UtilSQL {
	
	private UtilSQL() {
		super();
	}
	
	public static final boolean conexionAbierta(final Connection conexion) {
		if (UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico= "No es posible validar si una conexion está abierta cuando es nula";
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
		}
		try {
			return !(conexion.isClosed());
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000005);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
		catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000006);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
	}
	public static final void cerrarConexion(final Connection conexion) {
		if (UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico= "No es posible cerrar una conexion que está nula";
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
		}
		try {
			if (! conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
				var mensajeTecnico= "No es posible cerrar una conexion que ya está cerrada";
				throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
			}
			conexion.close();
		}catch(CrosscuttingHealthException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico= "Se ha presentado una excepcion tratando de cerrar una conexion SQL "
					+ "se presentó una exception de tipo SQLException, por favor verifique la traza completa\"\r\n"
					+ "				+ \"del error presentado, para así poder diagnosticar con mayor certeza que sucedio"
					+ " ya está cerrada";
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}catch(final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico= "Se ha presentado una excepcion inseperado tratando de cerrar una conexion SQL "
					+ "se presentó una exception de tipo generica, por favor verifique la traza completa\"\r\n"
					+ "				+ \"del error presentado, para así poder diagnosticar con mayor certeza que sucedio"
					+ " ya está cerrada";
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
	}
	public static final void iniciarTransaccion(final Connection conexion) {
		if (UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico= "No es posible iniciar una transaccion con una conexion que está nula";
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
		}
		try {
			if (! conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
				var mensajeTecnico= "No es posible iniciar una transaccion con una conexion cerrada";
				throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
			}
			if (!conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
				var mensajeTecnico= "No es posible iniciar una transaccion que ya ha sido iniciada";
				throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
			}
			conexion.setAutoCommit(false);
		}catch(CrosscuttingHealthException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico= "Se ha presentado una excepcion tratando de iniciar la transaccion de una conexion SQL "
					+ "se presentó una exception de tipo SQLException, por favor verifique la traza completa\"\r\n"
					+ "				+ \"del error presentado, para así poder diagnosticar con mayor certeza que sucedio"
					+ " ya está cerrada";
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}catch(final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico= "Se ha presentado una excepcion inseperado tratando de iniciar la transaccion de una conexion SQL "
					+ "se presentó una exception de tipo generica, por favor verifique la traza completa\"\r\n"
					+ "				+ \"del error presentado, para así poder diagnosticar con mayor certeza que sucedio"
					+ " ya está cerrada";
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
	}
	
	public static final void confirmarTransaccion(final Connection conexion) {
		if (UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico= "No es posible confirmar una transaccion con una conexion que está nula";
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
		}
		try {
			if (!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
				var mensajeTecnico= "No es posible confirmar una transaccion con una conexion cerrada";
				throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
			}
			if (conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
				var mensajeTecnico= "No es posible confirmar una transaccion que no fue iniciada";
				throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
			}
			conexion.commit();
		}catch(CrosscuttingHealthException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico= "Se ha presentado una excepcion tratando de confirmar la transaccion de una conexion SQL "
					+ "se presentó una exception de tipo SQLException, por favor verifique la traza completa\"\r\n"
					+ "				+ \"del error presentado, para así poder diagnosticar con mayor certeza que sucedio"
					+ " ya está cerrada";
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}catch(final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico= "Se ha presentado una excepcion inseperado tratando de confirmar la transaccion de una conexion SQL "
					+ "se presentó una exception de tipo generica, por favor verifique la traza completa\"\r\n"
					+ "				+ \"del error presentado, para así poder diagnosticar con mayor certeza que sucedio"
					+ " ya está cerrada";
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
	}
	
	public static final void cancelarTransaccion(final Connection conexion) {
		if (UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico= "No es posible cancelar una transaccion con una conexion que está nula";
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
		}
		try {
			if (!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
				var mensajeTecnico= "No es posible cancelar una transaccion con una conexion cerrada";
				throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
			}
			if (conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
				var mensajeTecnico= "No es posible cancelar una transaccion que no fue iniciada";
				throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
			}
			conexion.rollback();
		}catch(CrosscuttingHealthException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico= "Se ha presentado una excepcion tratando de cancelar la transaccion de una conexion SQL "
					+ "se presentó una exception de tipo SQLException, por favor verifique la traza completa\"\r\n"
					+ "				+ \"del error presentado, para así poder diagnosticar con mayor certeza que sucedio"
					+ " ya está cerrada";
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}catch(final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico= "Se ha presentado una excepcion inseperado tratando de cancelar la transaccion de una conexion SQL "
					+ "se presentó una exception de tipo generica, por favor verifique la traza completa\"\r\n"
					+ "				+ \"del error presentado, para así poder diagnosticar con mayor certeza que sucedio"
					+ " ya está cerrada";
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
	}
	
}
