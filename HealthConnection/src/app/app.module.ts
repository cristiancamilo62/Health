import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormpacienteComponent } from './login/formpaciente.component';
import { RegistroCitasComponent } from './registro-citas/registro-citas.component';

const routes: Routes = [
  { path: '', redirectTo:'/login' ,pathMatch:'full' },
  { path: 'login', component: LoginComponent },
  { path: 'login/form', component: FormpacienteComponent },
  { path: 'login/gestionCitas', component: RegistroCitasComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FormpacienteComponent,
    RegistroCitasComponent,


  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
