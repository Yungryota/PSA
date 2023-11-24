import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EscaneoTemperaturaComponent } from './escaneo-temperatura.component';

describe('EscaneoTemperaturaComponent', () => {
  let component: EscaneoTemperaturaComponent;
  let fixture: ComponentFixture<EscaneoTemperaturaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EscaneoTemperaturaComponent]
    });
    fixture = TestBed.createComponent(EscaneoTemperaturaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
