import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/Model/Usuario';
import { ServiceService } from '../../Service/service.service'
import { Location } from '@angular/common';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent {

  Usuarios: Usuario[] = [];

  constructor(private service:ServiceService, private router:Router, private location: Location ){

  }


    
  async ngOnInit(){
    console.log("Listado")
    this.service.getUsuarios()
    .subscribe(data=>{
      this.Usuarios=data;
    })
  }
}
