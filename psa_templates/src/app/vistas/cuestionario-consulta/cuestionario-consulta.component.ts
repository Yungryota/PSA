import { Component } from '@angular/core';
import { ServiceService } from 'src/app/Service/service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cuestionario-consulta',
  templateUrl: './cuestionario-consulta.component.html',
  styleUrls: ['./cuestionario-consulta.component.css']
})
export class CuestionarioConsultaComponent {
   respuestaPregunta1: string = '';
   respuesta: Array<string> = [];
   enviarRespuestas: String = '';

  constructor(private router: Router, private service: ServiceService){}
  
   guardarPreguntas(resp: string){
    this.respuesta.push(resp); 
    console.log('Funciona tu idea:', resp);
    console.log(this.respuesta)
  }
  
  guardarEdad(edad: string){
    this.respuesta.push('Edad: ' + edad); // Agrega la edad al arreglo de respuestas
    console.log('Edad ingresada:', edad);
    console.log(this.respuesta);
  }

  guardarConsulta(){ //R10 - paso 3: guarda datos consulta
    //sweetalert carga
    
    this.service.enviarConsultaPaciente(this.respuesta)//R10 - paso 4: solicitud servicio








    
    console.log('Respuestas paciente: ',this.respuesta)//R10 - paso 6: Registro evento por consola
    //R10 - paso 7: Mensaje exito
    this.router.navigate(['/resultado-consulta']);//R10 - paso 8: Redirige vista
  }

}
