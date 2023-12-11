import { Component, OnInit } from '@angular/core';
import { ServiceService } from 'src/app/Service/service.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cuestionario-consulta',
  templateUrl: './cuestionario-consulta.component.html',
  styleUrls: ['./cuestionario-consulta.component.css']
})
export class CuestionarioConsultaComponent implements OnInit{
  respuestaPregunta1: string = '';
  respuesta: Array<string> = [];
  enviarRespuestas: String = '';


  constructor(private router: Router, private service: ServiceService) { }
  ngOnInit(): void {
    Swal.fire({
      icon:"info",
      imageUrl:"https://media.discordapp.net/attachments/1139632235218223154/1183836133323444275/Sitio_Web_landing_page_diseno_delicado_minimalista_para_joyas_hechas_a_mano_dorado_y_beis_3.png?ex=6589c850&is=65775350&hm=c875241afab3ab7a7ad84c575cca79ff97233e177135a54454e3c9448e4913b9&=&format=webp&quality=lossless&width=881&height=495",
      imageWidth: 700,
      imageHeight: 350,
      footer: '<span class="rojo">Es importante que presione OK para continuar.</span>'
    });

  }

  guardarPreguntas(resp: string) {
    this.respuesta.push(resp + '\n');
    console.log('Funciona tu idea:', resp);
    console.log(this.respuesta)
  }

  guardarEdad(edad: string) {
    this.respuesta.push('Edad: ' + edad); // Agrega la edad al arreglo de respuestas
    console.log('Edad ingresada:', edad);
    console.log(this.respuesta);
  }

  guardarConsulta() { //R10 - paso 3: guarda datos consulta

    //sweetalert carga



    console.log('Respuestas paciente: ', this.respuesta)//R10 - paso 6: Registro evento por consola
    Swal.fire({
      title: "Cargando, Por favor espere un momento",
      
      didOpen: () => {
        Swal.showLoading();

        setTimeout(() => {
          // Cierra la alerta después de 2500 milisegundos (2.5 segundos)
          Swal.close();
        }, 2500);
      },
      willClose: () => {
        Swal.hideLoading();
      },
      timerProgressBar: true,
    });





    this.enviarRespuestas = this.respuesta.toString()
    this.service.enviarConsultaPaciente(this.enviarRespuestas).subscribe(
      (data) => {
        // Manejar la respuesta exitosa
        console.log('Respuesta exitosa:', data);
        // Redireccionar a otra página, por ejemplo:
        this.router.navigate(['/resultado-consulta']);
      },
      (error) => {
        console.error('Error al enviar consulta paciente:', error);
        // Puedes mostrar un mensaje de error al usuario o realizar otras acciones
      }
    );
    //R10 - paso 4: solicitud servicio
    console.log('Respuestas paciente: ', this.enviarRespuestas)//R10 - paso 6: Registro evento por consola
    //R10 - paso 7: Mensaje exito
    this.router.navigate(['/resultado-consulta']);//R10 - paso 8: Redirige vista
  }

}
