import { Component, OnInit } from "@angular/core";
import { CitaService } from "./cita.service";
import { Router } from "@angular/router";
import { Cita } from "./cita";

@Component({
    selector: 'app-formcita',
    templateUrl: './formcita.component.html',
    styleUrls: ['./formcita.component.css']
  })
  export class FormpacienteComponent implements OnInit{

    titulo:string="Registro de citas";

    cita:Cita = new Cita;

    constructor(private citaservice: CitaService, private router:Router){}

    ngOnInit(): void {
    }

    create():void{
        this.citaservice.create(this.cita).subscribe(
            (response)=>{
                console.log(response)
              },
           (error) => {
            // Manejar el error aquí
            console.error(error);
        
            // Acceder al mensaje de error
            if (error.error && error.error.mensajes && error.error.mensajes.length > 0) {
              const mensajeDeError = error.error.mensajes[0];
              alert(mensajeDeError);
            }
          }
            );
    }

    
  }
    