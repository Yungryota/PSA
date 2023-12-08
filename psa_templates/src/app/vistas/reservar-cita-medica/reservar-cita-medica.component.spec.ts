import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservarCitaMedicaComponent } from './reservar-cita-medica.component';

describe('ReservarCitaMedicaComponent', () => {
  let component: ReservarCitaMedicaComponent;
  let fixture: ComponentFixture<ReservarCitaMedicaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReservarCitaMedicaComponent]
    });
    fixture = TestBed.createComponent(ReservarCitaMedicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
