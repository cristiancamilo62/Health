import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Paciente } from './paciente';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  private url:string= "http://localhost:8080/health/api/v1/paciente";

  constructor(private http:HttpClient) { }

  create(paciente:Paciente):Observable<Paciente>{
    return this.http.post<Paciente>(this.url,paciente);
  }
  getCredenciales(correo:string,clave:string):Observable<Paciente[]>{
    return  this.http.get<Paciente[]>(this.url+'/'+correo+'/'+clave);
  }

}
