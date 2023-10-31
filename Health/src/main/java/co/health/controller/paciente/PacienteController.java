package co.health.controller.paciente;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.health.controller.concrete.response.Respuesta;
import co.health.crosscutting.exception.HealthException;
import co.health.service.dto.PacienteDTO;
import co.health.service.facade.concrete.paciente.RegistrarPacienteFacade;

@RestController
@RequestMapping("/api/v1/paciente")
public final class PacienteController {
	
	@GetMapping("/dummy")
	public final PacienteDTO obtenerDummy() {
		return PacienteDTO.crear();
	}
	

	@PostMapping()
	public final ResponseEntity<Respuesta<PacienteDTO>> registrar(@RequestBody PacienteDTO dto) {
		
		final Respuesta<PacienteDTO> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			
			RegistrarPacienteFacade facade = new RegistrarPacienteFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El cliente se ha registrado exitosamente");
			
		} catch (final HealthException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getRaizExcepcion().printStackTrace();
			//TODO: hacer logger de la excepcion
			
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema tratando de resgistrar el cliente");
			excepcion.printStackTrace();
			//TODO: hacer logger de la excepcion
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
	}
}
