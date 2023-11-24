import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarComponent } from './Paciente/listar/listar.component';
import { LoginPsaComponent } from './vistas/login-psa/login-psa.component';
import { CategorizacionPacienteComponent } from './vistas/categorizacion-paciente/categorizacion-paciente.component';
import { EscaneoTemperaturaComponent } from './vistas/escaneo-temperatura/escaneo-temperatura.component';


const routes: Routes = [
  { path: '', redirectTo: 'login-psa', pathMatch: 'full' }, // Ruta raíz redirige a login-psa
  { path: 'login-psa', component: LoginPsaComponent },
  { path: 'listar', component: ListarComponent },
  { path: 'categorizacion-paciente', component: CategorizacionPacienteComponent },
  { path: 'escaneo-temperaruta', component: EscaneoTemperaturaComponent }
  // Otras rutas de tu aplicación...
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
