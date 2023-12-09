import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CuestionarioConsultaComponent } from './cuestionario-consulta.component';

describe('CuestionarioConsultaComponent', () => {
  let component: CuestionarioConsultaComponent;
  let fixture: ComponentFixture<CuestionarioConsultaComponent>;
  
  
  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CuestionarioConsultaComponent]
    });
    fixture = TestBed.createComponent(CuestionarioConsultaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
