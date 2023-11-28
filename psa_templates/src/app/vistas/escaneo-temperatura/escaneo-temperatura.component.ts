import { Component } from '@angular/core';
import { ServiceService } from 'src/app/Service/service.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-escaneo-temperatura',
  templateUrl: './escaneo-temperatura.component.html',
  styleUrls: ['./escaneo-temperatura.component.css']
})
export class EscaneoTemperaturaComponent {
  temperaturaPaciente: string = "";


  constructor(private service: ServiceService, private router: Router){}

  escanearTemperatura() {
    // Suscripción al Observable
    this.service.recibirTemperatura().subscribe(
      (data: any) => {
        console.log(data); // Aquí recibes los datos del servidor
        // Llama a funciones que obtienen la temperatura
        //this.obtenerTemperaturaPaciente();// imprime temp
        this.temperaturaPaciente = data;
      },
      (error: any) => {
        console.error(error); // Manejo de errores si ocurre alguno
      }
    );
  }
  


  enviarTemperatura(){
    this.router.navigate(['/cuestionario-consulta']);
    console.log('hola')
  }
}
