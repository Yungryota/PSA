import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservaCitaMedicaComponent } from './reserva-cita-medica.component';

describe('ReservaCitaMedicaComponent', () => {
  let component: ReservaCitaMedicaComponent;
  let fixture: ComponentFixture<ReservaCitaMedicaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReservaCitaMedicaComponent]
    });
    fixture = TestBed.createComponent(ReservaCitaMedicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
