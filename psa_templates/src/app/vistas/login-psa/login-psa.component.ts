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
          this.isLoading = false; //DA_RF1 - PASO 4: PANTALLA CARGA-->
          this.UsuarioEncontrado = Usuario;
          this.mostrarMensaje = true;//DA_RF1 - PASO 8: FIGURA EN EL SISTEMA
          this.mensaje = 'El Usuario con RUT ' + this.rutABuscar + ' ha sido encontrado.';
          console.log(this.mensaje)
          this.router.navigate(['/categorizacion-paciente']);//DA_RF1 - PASO 9: REDIRIGE VISTA CATEGORIA
        } else {
          this.UsuarioEncontrado = null;//DA_RF1 - PASO 8: NO FIGURA EN EL SISTEMA
          this.mostrarMensaje = true;
          this.mensaje = 'El Usuario con RUT ' + this.rutABuscar + ' no ha sido encontrado.'; 
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
