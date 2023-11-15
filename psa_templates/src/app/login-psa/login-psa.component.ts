import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/Model/Usuario';
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
  UsuarioEncontrado: any; 
  isLoading: boolean = false;

  constructor(private service: ServiceService, private router: Router) {}

  buscarUsuario() {
    this.service.buscarUsuarioPorRut(this.rutABuscar).subscribe(
      (Usuario) => {
        if (Usuario) {
          this.isLoading = false; //pantalla carga
          this.UsuarioEncontrado = Usuario;
          this.mostrarMensaje = true;
          this.mensaje = 'El Usuario con RUT ' + this.rutABuscar + ' ha sido encontrado.';
          console.log(this.mensaje)
          this.router.navigate(['/categorizacion-paciente']);//redirige a vita categoria
        } else {
          this.UsuarioEncontrado = null;
          this.mostrarMensaje = true;
          this.mensaje = 'El Usuario con RUT ' + this.rutABuscar + ' no ha sido encontrado.'; //mensaje error
        }
      },
      (error) => {
        this.mostrarMensaje = true;
        this.mensaje = 'Hubo un error al buscar el Usuario.';
        console.error(error);
      }
      
    );


  }

  encenderLed() {
    this.service.encenderLed().subscribe(
    )
  }
  apagarLed() {
    this.service.apagarLed().subscribe(
    )
  }


  goView(){
      this.router.navigate(["/listar"])
  }
}
