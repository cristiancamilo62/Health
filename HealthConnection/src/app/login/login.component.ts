import { Component, OnInit } from '@angular/core';
import { Paciente } from './paciente';
import { PacienteService } from './paciente.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  correoElectronicoMandar: string = ''; 
  contraseniaMandar: string = '';

  constructor(private pacienteservice: PacienteService, private router: Router) { }

  ngOnInit(): void { }
  getCredenciales(): void {
    const correo = this.correoElectronicoMandar;
    const pasword = this.contraseniaMandar;
    this.pacienteservice.getCredenciales(correo,pasword).subscribe(
      (response) => {
        console.log(response.values)
        if (response && response[0]) {
          const paciente = response[0];
          const correoElectronico = paciente.contactoPaciente.correoElectronicoPaciente.correoElectronico;
          const contrasenia = paciente.contactoPaciente.contrasenia;
  
          if (correoElectronico === correo && contrasenia === pasword) {
            this.router.navigate(['login/gestionCitas'])
            console.log("Registro exitoso");
          } else {
            console.error("Las credenciales no coinciden.");
          }
        } else {
          console.error("La respuesta no contiene datos válidos.");
        }
      },
      (error) => {
        if (error.error && error.error.mensajes && error.error.mensajes.length > 0) {
          const mensajeDeError = error.error.mensajes[0];
          alert(mensajeDeError);
        }
      }
    );
  }
}