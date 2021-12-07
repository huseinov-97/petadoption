import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PetsListComponent } from './components/pets-list/pets-list.component';
import {HttpClientModule} from "@angular/common/http";
import {PetsService} from "./services/pets.service";
import {ShelterService} from "./services/shelter.service";
import {UserService} from "./services/user.service";
import {AdoptionService} from "./services/adoption.service";

@NgModule({
  declarations: [
    AppComponent,
    PetsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [PetsService, ShelterService, UserService, AdoptionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
