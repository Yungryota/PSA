import { Component, OnInit} from '@angular/core';
import { ServiceService } from 'src/app/Service/service.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-escaneo-temperatura',
  templateUrl: './escaneo-temperatura.component.html',
  styleUrls: ['./escaneo-temperatura.component.css']
})
export class EscaneoTemperaturaComponent implements OnInit{
  temperaturaPaciente: string = "";


  constructor(private service: ServiceService, private router: Router){}
  ngOnInit(): void {
    
    console.log('aca el modal con la foto');
  }

  //Función que recibe la temperatura desde spring
  escanearTemperatura() { //RF12 - Paso 3: Crea  solicitud
    this.service.recibirTemperatura().subscribe(//RF12 - Paso 4: Inicia función recibir temperatura
      (data: any) => {
        console.log(data); 
        //this.obtenerTemperaturaPaciente();// imprime temp
        if (data >= 30.00) { //RF12 - Paso 6: rango temperatura normal
          this.temperaturaPaciente = data;
        }else(
          this.temperaturaPaciente = 'Error al escanerar, por favor, inténtelo de nuevo' //RF12 - Paso 6: rango temperatura anoral
        )
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
