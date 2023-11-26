import { Component } from '@angular/core';

@Component({
  selector: 'app-cuestionario-consulta',
  templateUrl: './cuestionario-consulta.component.html',
  styleUrls: ['./cuestionario-consulta.component.css']
})
export class CuestionarioConsultaComponent {
   respuestaPregunta1: string = '';
   respuesta: Array<string> = [];


  
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

}
