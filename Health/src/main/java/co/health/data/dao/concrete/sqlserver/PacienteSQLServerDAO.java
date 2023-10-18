package co.health.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.health.data.dao.PacienteDAO;
import co.health.data.dao.base.SQLDAO;
import co.health.data.entity.CitaEntity;
import co.health.data.entity.PacienteEntity;

public final class PacienteSQLServerDAO extends SQLDAO implements PacienteDAO{

	public PacienteSQLServerDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void registar(final PacienteEntity paciente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void confirmarCorreoElectronico(final String correoElectronico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void confirmarNumeroTelefono(final String numeroTelefono) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void modificar(final PacienteEntity paciente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void cambiarEstadoCuenta(final PacienteEntity paciente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void confirmarCita(final CitaEntity cita) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Optional<PacienteEntity> consultarPorId(final UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public final List<PacienteEntity> consultar(final PacienteEntity paciente) {
		// TODO Auto-generated method stub
		return null;
	}

}
