import { Component, ViewEncapsulation  } from '@angular/core';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { MatRadioModule } from '@angular/material/radio';


@Component({
  selector: 'app-categorizacion-paciente',
  templateUrl: './categorizacion-paciente.component.html',
  styleUrls: ['./categorizacion-paciente.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class CategorizacionPacienteComponent {
  opcionSeleccionada: string = '';
  opcion1: boolean = false; // Variable para la opción 1
  opcion2: boolean = false; // Variable para la opción 2
  opcion3: boolean = false; // Variable para la opción 3
  task: any = {
    name: 'Indeterminate',
    completed: false,
    color: 'primary',
    subtasks: [
      { name: 'Primary', completed: false, color: 'primary' },
      { name: 'Accent', completed: false, color: 'accent' },
      { name: 'Warn', completed: false, color: 'warn' },
    ],
  };
  
  opcionesSeleccionadas() {
    if (this.opcion1) {
      console.log('Opción 1 seleccionada');
      // Realizar acciones específicas para la opción 1
    }

    if (this.opcion2) {
      console.log('Opción 2 seleccionada');
      // Realizar acciones específicas para la opción 2
    }

    if (this.opcion3) {
      console.log('Opción 3 seleccionada');
      // Realizar acciones específicas para la opción 3
    }
  }

}
