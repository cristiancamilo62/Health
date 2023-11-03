import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Cita } from "./cita";


@Injectable({
    providedIn: 'root'
  })
  export class CitaService {

    private url:string= "http://localhost:8080/health/api/v1/paciente";

    constructor(private http:HttpClient){}
    
    create(cita:Cita):Observable<Cita>{
        return this.http.post<Cita>(this.url,Cita)
    }
  }