import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Paciente } from '../Model/Paciente';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private apiUrl = 'http://localhost:8080'; // Reemplaza con la URL de tu servidor API

  constructor(private http: HttpClient) { }

  getPacientes(): Observable<Paciente[]> {
    // Verificar si la ubicación no es localhost:4200
    if (window.location.origin !== 'http://localhost:4200') {
      console.log('Solicitud no permitida desde esta ubicación.');
      // Puedes devolver un observable vacío o lanzar un error, según tu necesidad
      return new Observable<Paciente[]>(observer => {
        observer.complete(); // Observable vacío
      });
    }
    // Si la ubicación es localhost:4200, realizar la solicitud GET
    return this.http.get<Paciente[]>(`${this.apiUrl}/psa/hello`);
  }

  buscarPacientePorRut(rut: string): Observable<Paciente> {
    return this.http.get<Paciente>(`${this.apiUrl}/psa/${rut}`);
    
  }

  activarArduino() {
    return this.http.get(`${this.apiUrl}/psa/arduino`);
  }






  enviarCategoriaPaciente(categoriaPaciente: string): Observable<any> { // POST para enviar
    const data = { categoriaPaciente }; 
    return this.http.post<any>(`${this.apiUrl}/psa/enviarCategoriaPaciente`, data);
    console.log('POST enviado')
  }

  
}
