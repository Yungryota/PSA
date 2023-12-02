import { Component } from '@angular/core';
import { Router } from '@angular/router'

@Component({
  selector: 'app-resultado-consulta',
  templateUrl: './resultado-consulta.component.html',
  styleUrls: ['./resultado-consulta.component.css']
})
export class ResultadoConsultaComponent {
  emailUsuario: String = 'ejemplo@email.cl';

  constructor(private router: Router){}

  finalizarConsulta(){
    console.log('saliendo...')
    this.router.navigate(['/login-psa']);
  }

}
