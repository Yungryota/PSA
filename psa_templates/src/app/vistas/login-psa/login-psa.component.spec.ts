import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginPsaComponent } from './login-psa.component';

describe('LoginPsaComponent', () => {
  let component: LoginPsaComponent;
  let fixture: ComponentFixture<LoginPsaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LoginPsaComponent]
    });
    fixture = TestBed.createComponent(LoginPsaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
