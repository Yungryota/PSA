import { Component } from '@angular/core';

@Component({
  selector: 'app-cuestionario-consulta',
  templateUrl: './cuestionario-consulta.component.html',
  styleUrls: ['./cuestionario-consulta.component.css']
})
export class CuestionarioConsultaComponent {
  respuestaSiNo: string = 'Sí'; // Ejemplo de respuesta sí o no
  respuestaMultiple: string[] = ['Rojo', 'Azul']; // Ejemplo de respuesta múltiple
}
