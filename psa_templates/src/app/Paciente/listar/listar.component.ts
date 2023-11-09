import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Paciente } from 'src/app/Model/Paciente';
import { ServiceService } from '../../Service/service.service'
import { Location } from '@angular/common';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent {

  pacientes: Paciente[] = [];

  constructor(private service:ServiceService, private router:Router, private location: Location ){

  }


    
  async ngOnInit(){
    console.log("Listado")
    this.service.getPacientes()
    .subscribe(data=>{
      this.pacientes=data;
    })
  }
}
