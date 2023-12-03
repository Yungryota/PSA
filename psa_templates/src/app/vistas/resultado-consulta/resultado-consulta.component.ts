import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import * as Notiflix from 'notiflix';


@Component({
  selector: 'app-resultado-consulta',
  templateUrl: './resultado-consulta.component.html',
  styleUrls: ['./resultado-consulta.component.css']
})
export class ResultadoConsultaComponent {
  emailUsuario : String = '';
  asunto : String = 'Estimado doctor, se adjuntan síntomas del paciente esperando respuesta con posible diagnóstico y receta médica'
  sintomasConsulta: String = 'Ta enfelmo';
  categoriaPaciente: String = 'C4';


  constructor(private router: Router,private service : ServiceService){}

  //Funcion crea solicitud para enviar por parametros un mail al medico
  guardarMail() {
    this.service.enviarCorreoSintomasPaciente(this.emailUsuario,this.asunto,this.sintomasConsulta,this.categoriaPaciente)

    console.log('Correo guardado:', this.emailUsuario);
  }

  finalizarConsulta(){
    console.log('saliendo...')
    this.router.navigate(['/login-psa']);
  }

}
