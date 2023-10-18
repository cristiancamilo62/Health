package co.health.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.health.data.dao.CitaDAO;
import co.health.data.dao.base.SQLDAO;
import co.health.data.entity.CitaEntity;

public final class CitaSQLServerDAO extends SQLDAO implements CitaDAO{

	public CitaSQLServerDAO(final Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void agendar(final CitaEntity cita) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void enviarConfirmacion(final CitaEntity cita) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void cancelar(final CitaEntity cita) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void reprogramar(final CitaEntity cita) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void cambiarEstado(final CitaEntity cita) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Optional<CitaEntity> consultarPorId(final UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public final List<CitaEntity> consultar(final CitaEntity cita) {
		// TODO Auto-generated method stub
		return null;
	}

}
