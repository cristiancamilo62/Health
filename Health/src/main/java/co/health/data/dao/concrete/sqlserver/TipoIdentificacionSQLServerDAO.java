package co.health.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.health.data.dao.TipoIdentificacionDAO;
import co.health.data.dao.base.SQLDAO;
import co.health.data.entity.TipoIdentificacionEntity;

public class TipoIdentificacionSQLServerDAO extends SQLDAO implements TipoIdentificacionDAO{

	public TipoIdentificacionSQLServerDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void registrar(final TipoIdentificacionEntity tipoIdentificacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void modificar(final TipoIdentificacionEntity tipoIdentificacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void eliminar(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Optional<TipoIdentificacionEntity> consultarPorId(final UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public final List<TipoIdentificacionEntity> consultar(final TipoIdentificacionEntity tipoIdentificacion) {
		// TODO Auto-generated method stub
		return null;
	}

}
