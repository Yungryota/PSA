import { Component } from '@angular/core';
import { ServiceService } from 'src/app/Service/service.service';


@Component({
  selector: 'app-escaneo-temperatura',
  templateUrl: './escaneo-temperatura.component.html',
  styleUrls: ['./escaneo-temperatura.component.css']
})
export class EscaneoTemperaturaComponent {
  temperaturaPaciente: string = "";


  constructor(private service: ServiceService){}

  escanearTemperatura(){
    this.service.activarArduino().subscribe()
    console.log('Hola, estoy encendiendo el arduino')
    //Llama a funciones que obtiene la tempetarruta
    this.obtenerTemperaturaPaciente()
  }

  obtenerTemperaturaPaciente(){
    //Llama servicio que obtiene la temperatura escaneada desde arduino
    this.temperaturaPaciente = '40' +'°' // setea la temperatura con la obtenidad desde el llamado
  }
}
