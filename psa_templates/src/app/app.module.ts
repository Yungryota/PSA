import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListarComponent } from './Paciente/listar/listar.component';
import { ServiceService } from '../app/Service/service.service';
import {HttpClientModule} from '@angular/common/http';
import { LoginPsaComponent } from './vistas/login-psa/login-psa.component';
import { CategorizacionPacienteComponent } from './vistas/categorizacion-paciente/categorizacion-paciente.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { MatRadioModule } from '@angular/material/radio';
import { EscaneoTemperaturaComponent } from './vistas/escaneo-temperatura/escaneo-temperatura.component';
import { CuestionarioConsultaComponent } from './vistas/cuestionario-consulta/cuestionario-consulta.component';
import { ResultadoConsultaComponent } from './vistas/resultado-consulta/resultado-consulta.component';
import { ReservaCitaMedicaComponent } from './vistas/reserva-cita-medica/reserva-cita-medica.component';
import { ReservarCitaMedicaComponent } from './vistas/reservar-cita-medica/reservar-cita-medica.component';




@NgModule({
  declarations: [
    AppComponent,
    ListarComponent,
    LoginPsaComponent,
    CategorizacionPacienteComponent,
    EscaneoTemperaturaComponent,
    CuestionarioConsultaComponent,
    ResultadoConsultaComponent,
    ReservaCitaMedicaComponent,
    ReservarCitaMedicaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatProgressSpinnerModule,
    MatCheckboxModule,
    MatRadioModule
  ],
  providers: [ServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
