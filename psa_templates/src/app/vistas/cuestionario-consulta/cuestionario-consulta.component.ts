import { Component } from '@angular/core';
import { NeuralNetwork } from 'brain.js';


@Component({
  selector: 'app-cuestionario-consulta',
  templateUrl: './cuestionario-consulta.component.html',
  styleUrls: ['./cuestionario-consulta.component.css']
})
export class CuestionarioConsultaComponent {
   respuestaPregunta1: string = '';
   respuesta: Array<string> = [];
   net = new NeuralNetwork();
   prompIa: string = '';
  
   guardarPreguntas(resp: string){
    this.respuesta.push(resp); 
    console.log('Funciona tu idea:', resp);
    console.log(this.respuesta)
  }
  
  guardarEdad(edad: string){
    this.respuesta.push('Edad: ' + edad); 
    console.log('Edad ingresada:', edad);
    console.log(this.respuesta);
  }

  trainingData: { input: any, output: any }[] = [
    {
      input: "genera un diagnostico en 5 palabras para estos sintomas: Edad: 2, Sexo: Femenino, ConsumeTabaco: no, ConsumeAlcohol: no, Tos y dolor en el pecho, dificultad respiratoria, Fiebre: si, Dificultad al dormir, Diabetes: no, No padece enfermedad arterial, Enfermedad pulmonar: no, Hipertension: no, Sin dolor",
      output: "Ejemplo de diagnóstico para este conjunto de síntomas"
    },
  ];
  

  train(trainingData: { input: any, output: any }[]): void {
    this.net.train(trainingData);
  }  

  askQuestion() {
    const frasePrompt = "Genera un diagnóstico en 5 palabras para estos síntomas:";
    const sintomasUsuario = this.respuesta; 
    const newQuestion = `${frasePrompt} ${sintomasUsuario}`;
    
    this.prompIa = this.predictAnswer(newQuestion);

    console.log(this.prompIa);
  }
  
  predictAnswer(newQuestion: any): any {
    const prediction = this.net.run(newQuestion);
    return prediction;

  }
  
  

  


}
