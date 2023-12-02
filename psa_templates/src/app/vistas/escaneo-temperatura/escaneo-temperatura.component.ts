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

  //Función que recibe la temperatura desde spring
  escanearTemperatura() { //RF12 - Paso 3: Crea  solicitud
    this.service.recibirTemperatura().subscribe(//RF12 - Paso 4: Inicia función recibir temperatura
      (data: any) => {
        console.log(data); 
        //this.obtenerTemperaturaPaciente();// imprime temp
        this.temperaturaPaciente = data;
      },
      (error: any) => {
        console.error(error); 
      }
    );
  }

  enviarTemperatura(){
    this.router.navigate(['/cuestionario-consulta']);
    console.log('hola')
  }
}
