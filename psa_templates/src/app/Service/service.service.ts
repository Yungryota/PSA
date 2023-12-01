import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../Model/Usuario';
import { Consulta } from '../Model/Consulta';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private apiUrl = 'http://localhost:8080'; // Reemplaza con la URL de tu servidor API

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
    return this.http.get<Usuario>(`${this.apiUrl}/psa/${rut}`);
    
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

  enviarCategoriaUsuario(categoriaUsuario: string): Observable<any> { // POST para enviar
    const data = { categoriaUsuario }; 
    return this.http.post<any>(`${this.apiUrl}/psa/enviarCategoriaUsuario`, data);
    console.log('POST enviado')
  }

  recibirTemperatura() {
    return this.http.get(`${this.apiUrl}/psa/arduino/temp`);
  }

  enviarConsultaPaciente(respuesta: String): Observable<Consulta> {//DA_RF1 - PASO 5: SOLICITA DATOS
    return this.http.get<Consulta>(`${this.apiUrl}/psa/${respuesta}`);
  }


  
}
