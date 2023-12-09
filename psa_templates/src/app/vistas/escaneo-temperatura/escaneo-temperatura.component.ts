import { Component, OnInit} from '@angular/core';
import { ServiceService } from 'src/app/Service/service.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-escaneo-temperatura',
  templateUrl: './escaneo-temperatura.component.html',
  styleUrls: ['./escaneo-temperatura.component.css']
})
export class EscaneoTemperaturaComponent implements OnInit{
  temperaturaPaciente: string = "";


  constructor(private service: ServiceService, private router: Router){}
  ngOnInit(): void {
    Swal.fire({
      icon: "info",
      title: "Ejemplo de toma de temperatura.",
      imageUrl: "https://media.discordapp.net/attachments/1139632235218223154/1182796270176309288/image.png?ex=6585ffde&is=65738ade&hm=6e02e240c7582e2f3544f2d5f02f0f3b91eee0aedff9482c156fbf427e66ecbf&=&format=webp&quality=lossless&width=1089&height=662",
      imageWidth: 500,
      imageHeight: 300,
      imageAlt: "Custom image"
    });
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
