import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import Swal from 'sweetalert2';


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
  categoriaPaciente: string = ' ';

  constructor(private router: Router, private service: ServiceService) { }


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
      this.nivelPrioridad = this.nivelPrioridad;
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
      this.nivelPrioridad = this.nivelPrioridad
    }
    console.log(`El paciente ha sido categorizado como nivel de prioridad: ${this.nivelPrioridad}`);
  }

  evaluaComportamientoAnormal() { // Pregunta 3 
    if (this.respuestas['comportamiento anormal'] == true) {
      this.nivelPrioridad = 3;
    } else {
      this.nivelPrioridad = this.nivelPrioridad
    }
    console.log(`El paciente ha sido categorizado como nivel de prioridad: ${this.nivelPrioridad}`);
  }

  evaluaSituacionCatastrofe() { // Pregunta 4
    if (this.respuestas['situacion catastrofe'] == true) {
      this.nivelPrioridad = 3;
    } else {
      this.nivelPrioridad = this.nivelPrioridad
    }
    console.log(`El paciente ha sido categorizado como nivel de prioridad: ${this.nivelPrioridad}`);
  }

  tiempoSintomasPaciente() { // Funcion que evalua el tiempo de los sintomas y asigana puntaje 
    const tiempoSintomas = this.respuestas['Tiempo de los síntomas'] as number; // interpreta como number
    if (tiempoSintomas <= 6) {
      this.nivelPrioridad = this.nivelPrioridad;
    } else if (tiempoSintomas > 6 && tiempoSintomas <= 12) {
      this.nivelPrioridad = 4;
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

    if (this.nivelPrioridad == 1) {
      Swal.fire({
        icon: 'success',
        title: 'Usted es C1',
        text: 'Debera  dirigirse a mesón ya que PSA no puede cubrir su caso.',
        footer: '<span class="rojo">Es importante que presione OK para continuar.</span>'
      })

      this.categoriaPaciente = 'C1';
      this.router.navigate(["/login-psa"])
      console.log('categoria: ', this.categoriaPaciente)

    } else if (this.nivelPrioridad == 2) {
      Swal.fire({
        icon: 'success',
        title: 'Usted es C2',
        text: 'Debera  dirigirse a mesón ya que PSA no puede cubrir su caso.',
        footer: '<span class="rojo">Es importante que presione OK para continuar.</span>'
      })

      this.categoriaPaciente = 'C2';
      this.router.navigate(["/login-psa"])
      console.log('categoria: ', this.categoriaPaciente)

    } else if (this.nivelPrioridad == 3) {
      Swal.fire({
        icon: 'success',
        title: 'Usted es C3',
        text: 'Debera  dirigirse a mesón ya que PSA no puede cubrir su caso.',
        footer: '<span class="rojo">Es importante que presione OK para continuar.</span>'
      })
      this.categoriaPaciente = 'C3';
      this.router.navigate(["/login-psa"])
      console.log('categoria: ', this.categoriaPaciente)

    } else if (this.nivelPrioridad == 4) {
      //Si es C4
      Swal.fire({
        icon: 'success',
        title: 'Usted es C4',
        text: 'Ejemplo de toma de temperatura, presione OK, para continuar con la encuesta,',
        imageUrl: "https://media.discordapp.net/attachments/1139632235218223154/1182796270176309288/image.png?ex=6585ffde&is=65738ade&hm=6e02e240c7582e2f3544f2d5f02f0f3b91eee0aedff9482c156fbf427e66ecbf&=&format=webp&quality=lossless&width=1089&height=662",
        imageWidth: 400,
        imageHeight: 250,
        footer: '<span class="rojo">Es importante que presione OK para continuar.</span>'
      });
      
      this.categoriaPaciente = 'C4';
      this.router.navigate(["/escaneo-temperatura"])
      console.log('categoria: ', this.categoriaPaciente)

    } else if (this.nivelPrioridad == 5) {
      //Si es C5
      Swal.fire({
        icon: 'success',
        title: 'Usted es C5',
        text: 'Ejemplo de toma de temperatura, presione OK, para continuar con la encuesta,',
        imageUrl: "https://media.discordapp.net/attachments/1139632235218223154/1182796270176309288/image.png?ex=6585ffde&is=65738ade&hm=6e02e240c7582e2f3544f2d5f02f0f3b91eee0aedff9482c156fbf427e66ecbf&=&format=webp&quality=lossless&width=1089&height=662",
        imageWidth: 400,
        imageHeight: 250,
        footer: '<span class="rojo">Es importante que presione OK para continuar.</span>'
      });

      this.categoriaPaciente = 'C5';
      this.router.navigate(["/escaneo-temperatura"])
      console.log('categoria: ', this.categoriaPaciente)

    } else {
      prompt("Conteste el cuestionario para continuar");
    }

    this.service.enviarCategoriaUsuario(this.categoriaPaciente).subscribe() // solicitud post

  }




}
