import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarComponent } from './Paciente/listar/listar.component';
import { LoginPsaComponent } from './vistas/login-psa/login-psa.component';
import { CategorizacionPacienteComponent } from './vistas/categorizacion-paciente/categorizacion-paciente.component';
import { EscaneoTemperaturaComponent } from './vistas/escaneo-temperatura/escaneo-temperatura.component';
import { CuestionarioConsultaComponent } from './vistas/cuestionario-consulta/cuestionario-consulta.component';
import { ResultadoConsultaComponent } from './vistas/resultado-consulta/resultado-consulta.component';
import { ReservarCitaMedicaComponent } from './vistas/reservar-cita-medica/reservar-cita-medica.component';



const routes: Routes = [
  { path: '', redirectTo: 'login-psa', pathMatch: 'full' },
  { path: 'login-psa', component: LoginPsaComponent },
  { path: 'listar', component: ListarComponent },
  { path: 'categorizacion-paciente', component: CategorizacionPacienteComponent },
  { path: 'escaneo-temperatura', component: EscaneoTemperaturaComponent },
  { path: 'cuestionario-consulta', component: CuestionarioConsultaComponent },
  { path: 'resultado-consulta', component: ResultadoConsultaComponent },
  { path: 'reservar-cita', component: ReservarCitaMedicaComponent },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
