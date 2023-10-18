package co.health.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.health.crosscutting.exception.concrete.DataHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilTexto;
import co.health.data.dao.TipoIdentificacionDAO;
import co.health.data.dao.base.SQLDAO;
import co.health.data.entity.TipoIdentificacionEntity;

public class TipoIdentificacionSQLServerDAO extends SQLDAO implements TipoIdentificacionDAO{

	public TipoIdentificacionSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void registrar(final TipoIdentificacionEntity tipoIdentificacion) {
		final StringBuilder sentencia = new StringBuilder();
		
		sentencia.append("INSERT INTO TipoIdentificacion (id, codigo, nombre) ");
		sentencia.append("VALUES (?,?,?)");
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setObject(1, tipoIdentificacion.getId());
			sentenciaPreparada.setString(2, tipoIdentificacion.getCodigo());
			sentenciaPreparada.setString(3, tipoIdentificacion.getNombre());
			
			sentenciaPreparada.executeUpdate();
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000027);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000028);
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
			
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000027);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000029);
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
			
		} 
	}

	@Override
	public final void modificar(final TipoIdentificacionEntity tipoIdentificacion) {
		
		final StringBuilder sentencia = new StringBuilder();
		sentencia.append("UPDATE" );
		
		
	}

	@Override
	public final void eliminar(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Optional<TipoIdentificacionEntity> consultarPorId(final UUID id) {
		final StringBuilder sentencia = new StringBuilder();
		
		sentencia.append("SELECT  id, codigo, nombre ");
		sentencia.append("FROM TipoIdentificacion ");
		sentencia.append("WHERE id = ? ");
		
		Optional<TipoIdentificacionEntity> resultado = Optional.empty();
		
	try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
		
		sentenciaPreparada.setObject(1, id);
		
		resultado = ejecutarConsultaPorId(sentenciaPreparada);
	}
		catch (final DataHealthException excepcion) {
		throw excepcion;
	}
	catch (final SQLException excepcion) {
		var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030);
		var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000031);
		throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
	}
	catch (final Exception excepcion) {
		var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030);
		var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000032);
		throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
	}
	return resultado;
	}
	
	private  final Optional<TipoIdentificacionEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){
		
		Optional<TipoIdentificacionEntity> resultado = Optional.empty();
		try (final var resultados = sentenciaPreparada.executeQuery() ){
			if(resultados.next()) {
				var tipoIdentificacionEntity = TipoIdentificacionEntity.crear
						(UUID.fromString(resultados.getObject("id").toString()), resultados.getString("codigo"),
								resultados.getString("nombre"));
			resultado = Optional.of(tipoIdentificacionEntity);
				
			}
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000033);
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000034);
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
		
		
		return resultado;
	}
	
	private final String formarSentenciaConsulta(final TipoIdentificacionEntity tipoIdentificacion, final List<Object> parametros) {
		
		final StringBuilder sentencia = new StringBuilder();
		String operadorCondicional = "WHERE";
		
		sentencia.append("SELECT id,codigo,nombre ");
		sentencia.append("FROM TipoIdentificacion");
		
		if(!UtilObjeto.esNulo(tipoIdentificacion)) {
			
			if(UtilObjeto.esNulo(tipoIdentificacion.getId())) {
				sentencia.append(operadorCondicional).append(" id = ?");
				operadorCondicional = "AND";
				parametros.add(tipoIdentificacion.getId());
			}
			
			if(!UtilTexto.estaVacio(tipoIdentificacion.getCodigo())) {
				sentencia.append(operadorCondicional).append(" codigo = ?");
				operadorCondicional = "AND";
				parametros.add(tipoIdentificacion.getCodigo());
			}
			if(!UtilTexto.estaVacio(tipoIdentificacion.getNombre())) {
				sentencia.append(operadorCondicional).append(" nombre = ?");
				parametros.add(tipoIdentificacion.getNombre());
			}
			
		}
		sentencia.append("ORDER BY codigo ASC");
		return sentencia.toString();
	}
	@Override
	public final List<TipoIdentificacionEntity> consultar(final TipoIdentificacionEntity tipoIdentificacion) {
		
		final var parametros = new ArrayList<Object>();
		final String sentencia = formarSentenciaConsulta(tipoIdentificacion, parametros);
		
		try(final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentencia)){
			colocarParametrosConsulta(sentenciaPreparada,parametros);
			return ejecutarConsulta(sentenciaPreparada);
			
		} catch (final DataHealthException excepcion) {
			throw excepcion;
		}catch (final SQLException excepcion) {
			var mensajeUsuario = "Se ha presentado un problema, tratando de llevar a cabo la consulta de los Tipo de identificación";
			var mensajeTecnico = "Se ha presentado un problema de tipo SQLExepcion el método prepararEjecutarSentenciaConsulta de la clase TipoIdentificacionSQLServer"
					+ "tratando de preparar la sentencia SQL.Por favor revise la traza completa del problema presentado"
					+ "para asi identificar que sucedio y solucionar el problema.";
			throw DataHealthException.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}catch (final Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la consulta de los tipo de Identificación";
			var mensajeTecnico = "Se ha presentado un problema inesperado de tipo Exepcion el método prepararEjecutarSentenciaConsulta de la clase TipoIdentificacionSQLServer"
					+ "tratando de preparar la sentencia SQL.Por favor revise la traza completa del problema presentado"
					+ "para asi poder identificar que sucedio y solucionar el problema...";
			throw DataHealthException.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}
		
	}
	
	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada, final List<Object> parametros) {
		
		try {
			for (int indice = 0; indice<parametros.size(); indice++) {
				sentenciaPreparada.setObject(indice+1,parametros.get(indice));
			}
		}catch (final SQLException excepcion) {
			var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la consulta de los Tipo de identificación";
			var mensajeTecnico = "Se ha presentado un problema de tipo SQLExepcion el método colocarParametrosConsulta de la clase TipoIdentificacionSQLServer"
					+ "tratando de colocar los parametros de la consulta SQL.Por favor revise la traza completa del problema presentado"
					+ "para asi poder identificar que sucedio y solucionar el problema.";
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la consulta de los Tipo de identificación";
			var mensajeTecnico = "Se ha presentado un problema inesperado de tipo Exepcion el método colocarParametrosConsulta de la clase TipoIdentificacionSQLServer"
					+ "tratando de colocar los parametros de la consulta SQL.Por favor revise la traza completa del problema presentado"
					+ "para asi poder identificar que sucedio y solucionar el problema.";
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico);
		}
	} 
	private final List<TipoIdentificacionEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada){
		
		final var listaResultados = new ArrayList<TipoIdentificacionEntity>();
		try (final var resultados = sentenciaPreparada.executeQuery() ){
			while (resultados.next()) {
				var tipoIdentificacionEntity = TipoIdentificacionEntity.crear
						(UUID.fromString(resultados.getObject("id").toString()), resultados.getString("codigo"),
								resultados.getString("nombre"));
			listaResultados.add(tipoIdentificacionEntity);
			}
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000033);
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000034);
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
		return listaResultados;
	}

}
