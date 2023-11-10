import { Component } from '@angular/core';

@Component({
  selector: 'app-categorizacion-paciente',
  templateUrl: './categorizacion-paciente.component.html',
  styleUrls: ['./categorizacion-paciente.component.css'],
  
})
export class CategorizacionPacienteComponent {
  respuestas: { [key: string]: boolean | number } = {
    'Experimenta dolor': false,
    'Signo de hemorragia': false,
    'Cambios en la conciencia': false,
    'comportamiento anormal': false,
    'situacion catastrofe': false,
    'Tiempo de los síntomas': 0
  };

  nivelPrioridad: number = 5; 
  categoriaPaciente: string = '';

  

  evaluaDolorPaciente() {
    if (this.respuestas['Experimenta dolor'] == true) {
      const nivelDolor = parseInt(prompt("En una escala del 1 al 10, ¿cómo describiría el dolor?", '') || '0');
      if (nivelDolor >= 7) {
        this.nivelPrioridad = 1;
      } else if (nivelDolor >= 4) {
        this.nivelPrioridad = 2;
      } else {
        this.nivelPrioridad = 3;
      }
    } else {
      this.nivelPrioridad = 5;
    }
    console.log(`El paciente ha sido categorizado como nivel de prioridad: ${this.nivelPrioridad}`);
  }

  evaluaSignoHemorragia() { // Pregunta 1
    if (this.respuestas['Signo de hemorragia'] == true) {
      this.nivelPrioridad = 1;
    } else {
      this.nivelPrioridad = this.nivelPrioridad
    }

    console.log(`El paciente ha sido categorizado como nivel de prioridad: ${this.nivelPrioridad}`);
  }

  evaluaCambioConsiencia() { // Pregunta 2
    if (this.respuestas['Cambios en la conciencia'] == true) {
      this.nivelPrioridad = 2;
    } else {
      this.nivelPrioridad  = this.nivelPrioridad
    }
    console.log(`El paciente ha sido categorizado como nivel de prioridad: ${this.nivelPrioridad}`);
  }

  evaluaComportamientoAnormal() { // Pregunta 3 
    if (this.respuestas['comportamiento anormal'] == true) {
      this.nivelPrioridad = 3;
    } else {
      this.nivelPrioridad  = this.nivelPrioridad
    }
    console.log(`El paciente ha sido categorizado como nivel de prioridad: ${this.nivelPrioridad}`);
  }
 
  evaluaSituacionCatastrofe() { // Pregunta 4
    if (this.respuestas['situacion catastrofe'] == true) {
      this.nivelPrioridad = 3;
    } else {
      this.nivelPrioridad  = this.nivelPrioridad
    }
    console.log(`El paciente ha sido categorizado como nivel de prioridad: ${this.nivelPrioridad}`);
  }

  tiempoSintomasPaciente() { // Funcion que evalua el tiempo de los sintomas y asigana puntaje 
    const tiempoSintomas = this.respuestas['Tiempo de los síntomas'] as number; // interpreta como number
    if (tiempoSintomas <= 6) {
      this.nivelPrioridad = this.nivelPrioridad;
    } else if (tiempoSintomas > 6 && tiempoSintomas <= 12) {
      this.nivelPrioridad = 3;
    } else {
      this.nivelPrioridad = 1;
    }
    
    console.log(`El paciente ha sido categorizado como nivel de prioridad: ${this.nivelPrioridad}`);
  }

  responderPregunta1(pregunta: string, respuesta: boolean) {
    this.respuestas[pregunta] = respuesta;
    this.evaluaDolorPaciente();
  }

  responderPregunta2(pregunta: string, respuesta: boolean) {
    this.respuestas[pregunta] = respuesta;
    this.evaluaSignoHemorragia();
  }

  responderPregunta3(pregunta: string, respuesta: boolean) {
    this.respuestas[pregunta] = respuesta;
    this.evaluaCambioConsiencia();
  }

  cambiarTiempoSintomas(valor: number) {
    this.respuestas['Tiempo de los síntomas'] = valor;
    this.tiempoSintomasPaciente();
  }

  categorizacionPaciente() { // Categoriza al paciente segun su nivel de prioridad
    console.log(`PRIORIDAD PACIENTE: ${this.nivelPrioridad}`);
    if (this.nivelPrioridad = 1){
      this.categoriaPaciente = 'C1';
      const nivelDolor = prompt("UD debe ir a meson. Su nivel es:", this.categoriaPaciente);
    } else if (this.nivelPrioridad = 5) {
      this.categoriaPaciente = 'C4';
      const nivelDolor = prompt("Continue con la evaluacion. Su nivel es:", this.categoriaPaciente);
    }
  }
}
