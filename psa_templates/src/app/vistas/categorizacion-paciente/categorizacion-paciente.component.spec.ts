import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategorizacionPacienteComponent } from './categorizacion-paciente.component';

describe('CategorizacionPacienteComponent', () => {
  let component: CategorizacionPacienteComponent;
  let fixture: ComponentFixture<CategorizacionPacienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CategorizacionPacienteComponent]
    });
    fixture = TestBed.createComponent(CategorizacionPacienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
