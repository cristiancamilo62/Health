package co.health.crosscutting.messages;

import java.util.HashMap;
import java.util.Map;

import co.health.crosscutting.exception.concrete.CrosscuttingHealthException;
import co.health.crosscutting.messages.enumerator.CategoriaMensaje;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.messages.enumerator.TipoMensaje;
import co.health.crosscutting.util.UtilObjeto;

public final class CatalogoMensajes {

	private static final Map<CodigoMensaje, Mensaje> MENSAJES = new HashMap<CodigoMensaje, Mensaje>();
	
	static {
		cargarMensajes();
	}
	
	private CatalogoMensajes() {
		super();
	}
	

	
	public static void cargarMensajes() {
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000001, TipoMensaje.TECNICO,CategoriaMensaje.FATAL, "No se recibio el codigo de "
				+ "mensaje que se quería crear. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000002, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "No existe un mensaje con el "
				+ "código indicado. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000003, TipoMensaje.TECNICO,CategoriaMensaje.FATAL, "No es posible obtener un mensaje "
				+ "con un código vacio o nulo. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000004, TipoMensaje.USUARIO,CategoriaMensaje.FATAL, "Se a presentado un problema inesperado"
				+ " tratando de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte"
				+ "al administrador de la aplicación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000005, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema "
				+ "trantando de validar si la conexión SQL estaba abierta. Se presento una excepción de tipo SQLException. Por favor verifique"
				+ "la traza completa del error presentado, para así poder diagnosticar con mayor certeza lo que sucedio. "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000006, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema "
				+ "inesperado trantando de validar si la conexión SQL estaba abierta. Se presento una excepción generica de tipo Exception. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza lo que sucedio. "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000007, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "No es posible validar si una conexión "
				+ "esta abierta cuando es nula. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000008,TipoMensaje.TECNICO,CategoriaMensaje.ERROR,"no es posible cerrar una conexión "
				+ "que esta nula. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000009, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"no es posible cerrar una conexión "
				+ "que ya esta cerrada. Esto se debe a que una conexión que ha sido terminada o cerrada ya "
				+ "no se encuentra en un estado activo y operativo"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000010, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema trantando "
				+ " de cerrar la conexion SQL. Se presento una excepción de tipo SQLException. Por favor "
				+ "verifique la traza completa del error presentado, para poder diagnosticar "
				+ "con mayor certeza lo que sucedio.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000011, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado"
				+ "trantando de cerrar la conexión SQL. Se presento una excepción generica de tipo Exception. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar"
				+ "con mayor certeza lo que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000012,TipoMensaje.TECNICO,CategoriaMensaje.ERROR,"no es posible iniciar una transacción con una"
				+ "conexión que esta nula. No es posible continuar con el proceso.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000013, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"no es posible iniciar una transacción con una conexión "
				+ "cerrada. No es posible continuar con el proceso."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000014, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "no es posible iniciar una transacción que ya ha sido"
				+ "iniciada. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000015, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "se ha presentado un problema trantando"
				+ "de iniciar la transacción de una la conexion SQL. Se presento una excepción de tipo SQLException. Por favor "
				+ "verifique la traza completa del error presentado, para así poder diagnosticar"
				+ "con mayor certeza lo que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000016, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema"
				+ "trantando de iniciar la transacción de una conexión SQL. Se presento una excepción generica de tipo Exception. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar"
				+ "con mayor certeza lo que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000017,TipoMensaje.TECNICO,CategoriaMensaje.ERROR,"no es posible confirmar una transacción con una"
				+ "conexión que esta nula. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000018, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"no es posible confirmar una transacción con una conexión "
				+ "cerrada. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000019, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "no es posible confirmar una transacción que no ha sido"
				+ "iniciada. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000020, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema trantando"
				+ "de confirmar la transacción de una la conexion SQL. Se presento una excepción de tipo SQLException. Por favor "
				+ "verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza lo que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000021, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado "
				+ "trantando de confirmar la transacción de una conexión SQL. Se presento una excepción generica de tipo Exception. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza lo que sucedio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000022,TipoMensaje.TECNICO,CategoriaMensaje.ERROR,"no es posible cancelar una transacción con una"
				+ "conexión que esta nula. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000023, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"no es posible cancelar una transacción con una conexión "
				+ "cerrada. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000024, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "no es posible cancelar una transacción que no ha sido"
				+ "iniciada. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000025, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema trantando"
				+ "de cancelar una transacción de una la conexion SQL. Se presento una excepción de tipo SQLException. Por favor "
				+ "verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza lo que sucedio. "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000026, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado "
				+ "trantando de cancelar una transacción de una conexión SQL. Se presento una excepción generica de tipo Exception. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza lo que sucedio. "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000027, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un problema tratando de registrar "
				+ "la información del nuevo tipo de identificación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000028, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo SQLExcepcion en el metodo crear "
				+ "de la clase TipoIdentificacionSQLServer tratando de llevar a cabo el registro del "
				+ "nuevo tipo de Identificación. Por favor revise la traza completa del problema presentado"
				+ "para asi poder identificar que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000029, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Excepcion en el metodo crear "
				+ "de la clase TipoIdentificacionSQLServer tratando de llevar a cabo el registro del "
				+ "nuevo tipo de Identificación. Por favor revise la traza completa del problema presentado"
				+ "para asi identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000030, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un problema tratando de consultar "
				+ "la información de un tipo de identificación por el id"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000031, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo SQLExcepcion "
				+ "de la clase TipoIdentificacionSQLServer tratando de preparar la sentencia SQL de la consulta del "
				+ "tipo de Identificación deseada. Por favor revise la traza completa del problema presentado"
				+ "para asi identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000032, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Excepcion"
				+ "de la clase TipoIdentificacionSQLServer tratando de preparar la sentencia SQL de la consulta del "
				+ "tipo de Identificación deseada. Por favor revise la traza completa del problema presentado"
				+ "para asi poder identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000033, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo SQLExcepcion"
				+ "tratando de llevar a cabo la recuperación de los datos de la consulta del Tipo de Identificación deseado. Por favor revise la traza completa del problema presentado"
				+ "para asi poder identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000034, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Excepcion"
				+ "tratando de llevar a cabo la recuperación de los datos de la consulta del Tipo de Identificación deseado. Por favor revise la traza completa del problema presentado"
				+ "para asi poder identificar que sucedio y solucionar el problema."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000035, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha producido una excepción de tipo SQLException al intentar eliminar un "
				+ "registro en la base de datos con el ID proporcionado. Para resolver este problema, revise los detalles técnicos proporcionados y asegúrese de que el ID proporcionado "
				+ "sea válido y cumpla con las restricciones de la base de datos. Además, verifique la validez de la sentencia SQL de eliminación en su código."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000036, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un problema tratando de eliminar "
				+ "la información de un tipo de identificación por el id"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000037, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Exception al intentar eliminar un "
				+ "registro en la base de datos con el ID proporcionado. Para resolver este problema, revise los detalles técnicos proporcionados y asegúrese de que el ID proporcionado "
				+ "sea válido y cumpla con las restricciones de la base de datos. Además, verifique la validez de la sentencia SQL de eliminación en su código."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000038, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"La Factorìa de datos para PostgreSQL no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000039, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"La Factorìa de datos para MySQL no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000040, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"La Factorìa de datos para Oracle no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000041, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"La Factorìa de datos deseada no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000042, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de obtener la conexión con SQL Server. Se presentó una excepción de tipo SQLException. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000043, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de obtener la conexión con SQL Server. Se presentó una excepción genérica de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000044, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de crear el DAO deseado, debido a que la conexiòn actualmente està cerrada, por lo que no hay una conexiòn vàlida disponible..."));

	}
	

	private static final void agregarMensaje(final Mensaje mensaje) {
		MENSAJES.put(mensaje.getCodigo(), mensaje);
	}
	
	private static final Mensaje obtenerMensaje(final CodigoMensaje codigo) {
		if(UtilObjeto.esNulo(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M0000003);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
		}
		
		if(!MENSAJES.containsKey(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M0000002);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
		}
		
		return MENSAJES.get(codigo);
	}
	
	public static final String obtenerContenidoMensaje( final CodigoMensaje codigo) {
		return obtenerMensaje(codigo).getContenido();
	}
}
