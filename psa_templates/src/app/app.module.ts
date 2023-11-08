import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListarComponent } from './Paciente/listar/listar.component';
import { ServiceService } from '../app/Service/service.service';
import {HttpClientModule} from '@angular/common/http';
import { LoginPsaComponent } from './login-psa/login-psa.component'

@NgModule({
  declarations: [
    AppComponent,
    ListarComponent,
    LoginPsaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
