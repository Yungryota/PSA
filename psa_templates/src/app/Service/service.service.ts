import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../Model/Usuario';
import { Consulta } from '../Model/Consulta';
import { Observable } from 'rxjs';
import * as Notiflix from 'notiflix';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private apiUrl = 'http://localhost:8080'; // Reemplaza con la URL de tu servidor API
  private emailUrl = 'http://localhost:3000';

  constructor(private http: HttpClient) { }

  getUsuarios(): Observable<Usuario[]> {
    // Verificar si la ubicación no es localhost:4200
    if (window.location.origin !== 'http://localhost:4200') {
      console.log('Solicitud no permitida desde esta ubicación.');
      // Puedes devolver un observable vacío o lanzar un error, según tu necesidad
      return new Observable<Usuario[]>(observer => {
        observer.complete(); // Observable vacío
      });
    }
    // Si la ubicación es localhost:4200, realizar la solicitud GET
    return this.http.get<Usuario[]>(`${this.apiUrl}/psa/hello`);
  }

  buscarUsuarioPorRut(rut: string): Observable<Usuario> {//DA_RF1 - PASO 5: SOLICITA DATOS
    return this.http.get<Usuario>(`${this.apiUrl}/psa/rut/${rut}`);
    
  }

  encenderLed() {
    return this.http.get(`${this.apiUrl}/psa/arduino/encender`);
  }

  apagarLed() {
    return this.http.get(`${this.apiUrl}/psa/arduino/apagar`);
  }
  activarArduino() {
    return this.http.get(`${this.apiUrl}/psa/arduino`);
  }

  //Función que solicita temperatura 
  recibirTemperatura() { //RF12 - Paso 4: Instancia función obtener temperatura
    return this.http.get(`${this.apiUrl}/psa/arduino/temp`);
  }

  enviarConsultaPaciente(respuesta: String): Observable<Consulta> {//DA_RF1 - PASO 5: SOLICITA DATOS
    return this.http.get<Consulta>(`${this.apiUrl}/psa/respuesta/${respuesta}`);
  }

  enviarCategoriaUsuario(categoria: string,): Observable<Usuario> {//DA_RF1 - PASO 5: SOLICITA DATOS
    return this.http.get<Usuario>(`${this.apiUrl}/psa/categoria/${categoria}`);
  }

  //servicio envio correo electronico con los sintomas del paciente al medico 
  enviarCorreoSintomasPaciente(emailMedico : String, emailUsuario : String, asunto : String, sintomasConsulta : String, categoriaPaciente : String){
    Notiflix.Loading.standard('Enviando email')

    let parametros = {
      pEmailMedico : emailMedico,
      pEmailUsuario : emailUsuario,
      pAsunto : asunto,
      pSintomasCon : sintomasConsulta,
      pCategoriaPaciente : categoriaPaciente
    }

    console.log(parametros)

    this.http.post('http://localhost:3000/envio', parametros).subscribe(resp=>{
      console.log(resp)
      Notiflix.Notify.success('Email enviado correctamente')

    },
      err => Notiflix.Notify.failure('No se ha podido enviar el email')
    )

    Notiflix.Loading.remove()

  }
  
}
