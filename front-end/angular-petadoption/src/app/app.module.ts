import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {PetsListComponent} from './components/pets-list/pets-list.component';
import {HttpClientModule} from "@angular/common/http";
import {PetsService} from "./services/pets.service";
import {ShelterService} from "./services/shelter.service";
import {UserService} from "./services/user.service";
import {AdoptionService} from "./services/adoption.service";
import {ShelterListComponent} from './components/shelter-list/shelter-list.component';
import {UserListComponent} from './components/user-list/user-list.component';
import {AdoptionListComponent} from './components/adoption-list/adoption-list.component';
import { PetDetailsComponent } from './components/pet-details/pet-details.component';
import { ShelterDetailsComponent } from './components/shelter-details/shelter-details.component';


@NgModule({
  declarations: [
    AppComponent,
    PetsListComponent,
    ShelterListComponent,
    UserListComponent,
    AdoptionListComponent,
    PetDetailsComponent,
    ShelterDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [PetsService, ShelterService, UserService, AdoptionService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
