import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Paciente } from 'src/app/Model/Paciente';
import { ServiceService } from 'src/app/Service/service.service';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';


@Component({
  selector: 'app-login-psa',
  templateUrl: './login-psa.component.html',
  styleUrls: ['./login-psa.component.css']
})
export class LoginPsaComponent {
  rutABuscar: string = '';
  mostrarMensaje: boolean = false;
  mensaje: string = '';
  pacienteEncontrado: any; 
  isLoading: boolean = false;

  constructor(private service: ServiceService, private router: Router) {}

  buscarPaciente() {
    this.service.buscarPacientePorRut(this.rutABuscar).subscribe(
      (paciente) => {
        if (paciente) {
          this.isLoading = false; //pantalla carga
          this.pacienteEncontrado = paciente;
          this.mostrarMensaje = true;
          this.mensaje = 'El paciente con RUT ' + this.rutABuscar + ' ha sido encontrado.';
          console.log(this.mensaje)
          this.router.navigate(['/categorizacion-paciente']);//redirige a vita categoria
        } else {
          this.pacienteEncontrado = null;
          this.mostrarMensaje = true;
          this.mensaje = 'El paciente con RUT ' + this.rutABuscar + ' no ha sido encontrado.'; //mensaje error
        }
      },
      (error) => {
        this.mostrarMensaje = true;
        this.mensaje = 'Hubo un error al buscar el paciente.';
        console.error(error);
      }
    );


  }
  goView(){
      this.router.navigate(["/listar"])
  }
}
