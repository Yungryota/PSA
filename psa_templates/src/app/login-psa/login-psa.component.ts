import { Component } from '@angular/core';
import { Paciente } from 'src/app/Model/Paciente';
import { ServiceService } from 'src/app/Service/service.service';


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

  constructor(private service: ServiceService) {}

  buscarPaciente() {
    this.service.buscarPacientePorRut(this.rutABuscar).subscribe(
      (paciente) => {
        if (paciente) {
          this.pacienteEncontrado = paciente;
          this.mostrarMensaje = true;
          this.mensaje = 'El paciente con RUT ' + this.rutABuscar + ' ha sido encontrado.';
        } else {
          this.pacienteEncontrado = null;
          this.mostrarMensaje = true;
          this.mensaje = 'El paciente con RUT ' + this.rutABuscar + ' no ha sido encontrado.';
        }
      },
      (error) => {
        this.mostrarMensaje = true;
        this.mensaje = 'Hubo un error al buscar el paciente.';
        console.error(error);
      }
    );
  }
}
