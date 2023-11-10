import { Component } from '@angular/core';

@Component({
  selector: 'app-categorizacion-paciente',
  templateUrl: './categorizacion-paciente.component.html',
  styleUrls: ['./categorizacion-paciente.component.css']
})
export class CategorizacionPacienteComponent {
  respuestas: { [key: string]: boolean | number } = {
    'Experimenta dolor': false,
    'Signo de hemorragia': false,
    'Cambios en la conciencia': false,
    'Fiebre o temperatura anormal': false,
    'Tiempo de los síntomas': 0 // Inicializado con menos de 6 horas
    // Agrega el resto de preguntas
  };

  nivel_prioridad: number = 5; // Inicializado en 5 por defecto

  evaluarPrioridad() {
    if (this.respuestas['Experimenta dolor']) {
      const nivel_dolor = parseInt(prompt("En una escala del 1 al 10, ¿cómo describiría el dolor?", '') || '0');
      if (nivel_dolor >= 7) {
        this.nivel_prioridad = 1;
      } else if (nivel_dolor >= 4) {
        this.nivel_prioridad = 2;
      } else {
        this.nivel_prioridad = 3;
      }
    }

    if (this.respuestas['Signo de hemorragia']) {
      this.nivel_prioridad = 1;
    }

    if (this.respuestas['Cambios en la conciencia']) {
      this.nivel_prioridad = 2;
    }

    if (this.respuestas['Fiebre o temperatura anormal']) {
      this.nivel_prioridad = 3;
    }

    const tiempo_sintomas = this.respuestas['Tiempo de los síntomas'] as number; // Asegura que sea tratado como un número
    if (tiempo_sintomas <= 6) {
      this.nivel_prioridad = 3;
    } else if (tiempo_sintomas > 6 && tiempo_sintomas <= 12) {
      this.nivel_prioridad = 4;
    } else {
      this.nivel_prioridad = 5;
    }

    console.log(`El paciente ha sido categorizado como nivel de prioridad: ${this.nivel_prioridad}`);
  }

  responderPregunta(pregunta: string, respuesta: boolean) {
    this.respuestas[pregunta] = respuesta;
    this.evaluarPrioridad();
  }

  cambiarTiempoSintomas(valor: number) {
    this.respuestas['Tiempo de los síntomas'] = valor;
    this.evaluarPrioridad();
  }
}
