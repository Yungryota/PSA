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
  emailMedico : String = '';
  asunto : String = 'Estimado doctor, se adjuntan síntomas del paciente esperando respuesta con posible diagnóstico y receta médica'
  sintomasConsulta: String = 'Rut usuario: ' + this.mostrarRutUsuario() 
                             + '\n' + 'Categorización triage;' + this.mostrarCategoriaPaciente() 
                             + '\n' + 'Síntomas: ' + '\n' + this.mostrarConsulta()
                             + '\n' + 'Por favor, enviar repspuesta a consulta a correo: ' + this.emailMedico;
  categoriaPaciente: String = this.mostrarCategoriaPaciente();
  temperaturaPaciente: String = '35.5' ;


  constructor(private router: Router,private service : ServiceService){}

  //Funcion crea solicitud para enviar por parametros un mail al medico
  guardarMail() {
    this.service.enviarCorreoSintomasPaciente(this.emailMedico,this.asunto,this.sintomasConsulta,this.categoriaPaciente)

    console.log('Correo guardado:', this.emailMedico);
  }

  
  

  finalizarConsulta(){
    console.log('saliendo...')
    this.router.navigate(['/login-psa']);
  }

  mostrarTemp(){
    this.service.recibirTemperatura();
    return ;
  }

  mostrarConsulta(){
    return this.service.getConsultaSintomas();
  }

  mostrarCategoriaPaciente(){
    return this.service.getCategoriaPaciente();
  }

  mostrarRutUsuario(){
    return this.service.getRutUsuario();
  }

  mostrarTemperatura(){
    return this.service.getTemperaturaPaciente();
  }
}
